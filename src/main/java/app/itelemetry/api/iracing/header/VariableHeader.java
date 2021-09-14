package app.itelemetry.api.iracing.header;

import java.nio.ByteBuffer;
import java.util.function.Supplier;

public class VariableHeader {

    public static final int IRSDK_MAX_STRING = 32;
    public static final int IRSDK_MAX_DESC   = 64;

    public static final int NUMBER_OF_FIELDS = 4;
    public static final int SIZEOF_FIELDS    = 4;
    public static final int VAR_HEADER_SIZE  = (NUMBER_OF_FIELDS * SIZEOF_FIELDS) + IRSDK_MAX_STRING + IRSDK_MAX_DESC + IRSDK_MAX_STRING;

    private final HeaderType headerType;
    private final int offset;
    private final int count;
    private final char[] pad;
    private final String name;
    private final String description;
    private final String units;

    private final Supplier<ByteBuffer> bufferFetch;

    public VariableHeader(
            HeaderType headerType, int offset, int count, char[] pad, String name, String description, String units,
            Supplier<ByteBuffer> bufferFetch
    ) {
        this.headerType = headerType;
        this.offset = offset;
        this.count = count;
        this.pad = pad;
        this.name = name;
        this.description = description;
        this.units = units;
        this.bufferFetch = bufferFetch;
    }

    public HeaderType getHeaderType() {
        return headerType;
    }

    public int getOffset() {
        return offset;
    }

    public int getCount() {
        return count;
    }

    public char[] getPad() {
        return pad;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getUnits() {
        return units;
    }

    public Object getValue() {
        return getHeaderType().getValue(this);
    }

    public ByteBuffer getBuffer() {
        return bufferFetch.get();
    }

    public static VariableHeader readHeader(ByteBuffer buffer, Supplier<ByteBuffer> bufferFetch) {
        int headerOffset = 0;

        int type = buffer.getInt(headerOffset);
        headerOffset += 4;

        int offset = buffer.getInt(headerOffset);
        headerOffset += 4;

        int count = buffer.getInt(headerOffset);
        headerOffset += 4;

        char[] pad = new char[3];
        // for (int i = 0; i < pad.length; i++) {
        //     pad[i] = buffer.getChar();
        // }
        headerOffset += 4;

        byte[] nameBuffer = new byte[IRSDK_MAX_STRING];
        buffer.position(headerOffset);
        buffer.get(nameBuffer, 0, nameBuffer.length);
        String name = new String(nameBuffer).replaceAll("[\000]", "");
        headerOffset += IRSDK_MAX_STRING;

        byte[] descriptionBuffer = new byte[IRSDK_MAX_DESC];
        buffer.position(headerOffset);
        buffer.get(descriptionBuffer, 0, descriptionBuffer.length);
        String description = new String(descriptionBuffer).replaceAll("[\000]", "");
        headerOffset += IRSDK_MAX_DESC;

        byte[] unitsBuffer = new byte[IRSDK_MAX_STRING];
        buffer.position(headerOffset);
        buffer.get(unitsBuffer, 0, unitsBuffer.length);
        String units = new String(unitsBuffer).replaceAll("[\000]", "");

        return new VariableHeader(HeaderType.values()[type], offset, count, pad, name, description, units, bufferFetch);
    }

}
