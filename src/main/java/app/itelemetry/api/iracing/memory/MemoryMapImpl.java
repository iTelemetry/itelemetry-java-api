package app.itelemetry.api.iracing.memory;

import app.itelemetry.api.iracing.config.MemoryMapConfig;
import app.itelemetry.api.iracing.header.FileHeader;
import app.itelemetry.api.iracing.header.HeaderType;
import app.itelemetry.api.iracing.header.VariableHeader;
import app.itelemetry.api.iracing.kernel.KernelProxy;
import app.itelemetry.api.iracing.yml.IRData;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.WinNT.HANDLE;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.charset.UnsupportedCharsetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MemoryMapImpl implements MemoryMap {

    private static final Logger LOGGER = LoggerFactory.getLogger(MemoryMapImpl.class);
    private static final Pattern STATUS_PATTERN = Pattern.compile("(?<var>running):(?<val>\\d)");

    private static final KernelProxy myKernel32 = KernelProxy.INSTANCE;

    public static int FILE_MAP_READ = 4;

    private final MemoryMapConfig config;

    private long updatedAt;
    private boolean relativeUpdate = false;

    private ByteBuffer buffer;
    private long bufferUpdatedAt;

    private HANDLE handle;
    private Pointer view;
    private FileHeader fileHeader;

    private Map<String, VariableHeader> headers;
    private Map<Integer, Map<String, VariableHeader>> driverHeaders;
    private IRData file;

    private int simStatus = -99;

    public MemoryMapImpl(MemoryMapConfig config) {
        this.config = config;
    }

    @Override
    public boolean isConnected() {
        update();
        return file != null && getStatus() == 1 && getSimStatus() == 1;
    }

    private int fetchSimStatus() {
        HttpResponse<String> result;
        try {
            result = Unirest.get("http://127.0.0.1:32034/get_sim_status?object=simStatus")
                    .connectTimeout(500).socketTimeout(500).asString();
        } catch (UnirestException ex) {
            return -5;
        }

        if (!result.isSuccess()) {
            return -1;
        }

        String resStr = result.getBody();
        Matcher matcher = STATUS_PATTERN.matcher(resStr);
        if (!matcher.find()) {
            return -2;
        }

        String var = matcher.group("var");
        if (!var.equals("running")) {
            return -3;
        }

        String val = matcher.group("val");
        try {
            return Integer.parseInt(val);
        } catch (NumberFormatException ex) {
            return -4;
        }
    }

    @Override
    public int getSimStatus() {
        update();
        return simStatus;
    }

    @Override
    public int getStatus() {
        update();
        return fileHeader.getStatus();
    }

    @Override
    public FileHeader getFileHeader() {
        update();
        return fileHeader;
    }

    @Override
    public VariableHeader getHeader(String name) {
        update();
        return headers.get(name);
    }

    @Override
    public float getDriverHeaderFloat(String name, int carIdx) {
        update();

        VariableHeader header = getHeader(name);
        return getLatestVariableBuffer().getFloat(header.getOffset() + (carIdx * HeaderType.IRSDK_FLOAT.getBytes()));
    }

    @Override
    public int getDriverHeaderInt(String name, int carIdx) {
        update();

        ByteBuffer buf = getLatestVariableBuffer();
        VariableHeader header = getHeader(name);
        return buf.getInt(header.getOffset() + (carIdx * HeaderType.IRSDK_INT.getBytes()));
    }

    @Override
    public boolean getDriverHeaderBoolean(String name, int carIdx) {
        update();

        VariableHeader header = getHeader(name);
        return getLatestVariableBuffer().getInt(header.getOffset() + (carIdx * HeaderType.IRSDK_FLOAT.getBytes())) == 1;
    }

    @Override
    public boolean isRelativeUpdate() {
        boolean val = relativeUpdate;
        if (val) {
            relativeUpdate = false;
        }

        return val;
    }

    @Override
    public IRData getData() {
        update();
        return file;
    }

    private void update() {
        if (updatedAt > 0 && updatedAt > (System.currentTimeMillis() - config.getFileRefreshInterval())) {
            return;
        }

        simStatus = fetchSimStatus();
        if (simStatus != 1) {
            return;
        }

        Integer sessionId = null;
        if (file != null) {
            sessionId = file.getWeekendInfo().getSessionId();
        }

        handle = myKernel32.OpenFileMapping(FILE_MAP_READ, false, "Local\\IRSDKMemMapFileName");
        view = myKernel32.MapViewOfFile(handle, FILE_MAP_READ, 0, 0, 0);

        if (view == null) {
            file = null;
            updatedAt = System.currentTimeMillis();
            return;
        }

        ByteBuffer buffer = view.getByteBuffer(0, 112);
        fileHeader = new FileHeader(buffer);

        byte[] content = view.getByteArray(fileHeader.getSessionInfoOffset(), fileHeader.getSessionInfoLength());

        String yamlContent; //, StandardCharsets.ISO_8859_1
        try {
            final Charset fromCharset = Charset.forName("windows-1252");
            final Charset toCharset = StandardCharsets.UTF_8;

            CharBuffer charBuffer = fromCharset.decode(ByteBuffer.wrap(content));
            byte[] utfEncoded = toCharset.encode(charBuffer).array();

            yamlContent = new String(utfEncoded);

            // yamlContent = new String(content, fromCharset);
            // yamlContent = new String(new String(content, fromCharset).getBytes(fromCharset), toCharset);
        } catch (UnsupportedCharsetException ex) {
            LOGGER.error("Unsupported charset!", ex);
            return;
        } catch (Throwable ex) {
            LOGGER.error("Unexpected error :(", ex);
            return;
        }

        if (yamlContent.length() == 0) {
            file = null;
            return;
        }

        yamlContent = yamlContent.substring(0, yamlContent.indexOf("...") + 3);

        headers = new HashMap<>();
        Supplier<ByteBuffer> bufferFetch = this::getLatestVariableBuffer;

        for (long i = 0; i < fileHeader.getNumberOfVariables(); i++) {
            ByteBuffer buf = view
                    .getByteBuffer(fileHeader.getVariableHeaderOffset() + (i * VariableHeader.VAR_HEADER_SIZE),
                                   fileHeader.getBufferLength()
                    );
            VariableHeader vh = VariableHeader.readHeader(buf, bufferFetch);
            headers.put(vh.getName(), vh);
        }

        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
        mapper.configure(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT, true);

        ByteArrayInputStream bais = new ByteArrayInputStream(yamlContent.getBytes());
        Reader reader = new InputStreamReader(bais, Charset.forName("WINDOWS-1252"));

        try {
            file = mapper.readValue(reader, IRData.class);
        } catch (Exception ex) {
            LOGGER.error("Unable to parse file", ex);
            LOGGER.info("File {}", yamlContent);
            file = null;
        }

        if (file != null && !Objects.equals(file.getWeekendInfo().getSessionId(), sessionId)) {
            LOGGER.info("Session ID changed from {} to {}", sessionId, file.getWeekendInfo().getSessionId());
            relativeUpdate = true;
        }

        updatedAt = System.currentTimeMillis();
    }

    public ByteBuffer getLatestVariableBuffer() {
        if (buffer != null && bufferUpdatedAt > 0
                && bufferUpdatedAt > (System.currentTimeMillis() - (config.getCollectFrequency()))) {
            return buffer;
        }

        buffer = view.getByteBuffer(
                fileHeader.getVariableBufferOffset(fileHeader.getLatestVariableBufferIndex()),
                fileHeader.getBufferLength()
        );

        return buffer;
    }

}
