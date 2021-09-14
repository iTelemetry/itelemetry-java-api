package app.itelemetry.api.iracing.header;

import java.nio.ByteBuffer;

public class FileHeader {

    public final static int VARBUF_SIZE = 4 * 4;

    private final ByteBuffer buffer;

    public FileHeader(ByteBuffer buffer) {
        this.buffer = buffer;
    }

    public int getVersion() {
        return buffer.getInt(0);
    }

    public int getStatus() {
        return buffer.getInt(4);
    }

    public int getTickRate() {
        return buffer.getInt(8);
    }

    public int getSessionInfoVersion() {
        return buffer.getInt(12);
    }

    public int getSessionInfoLength() {
        return buffer.getInt(16);
    }

    public int getSessionInfoOffset() {
        return buffer.getInt(20);
    }

    public int getNumberOfVariables() {
        return buffer.getInt(24);
    }

    public int getVariableHeaderOffset() {
        return buffer.getInt(28);
    }

    public int getNumberBuffer() {
        return buffer.getInt(32);
    }

    public int getBufferLength() {
        return buffer.getInt(36);
    }

    public int getTickCount(int varBuf) {
        return buffer.getInt((varBuf * VARBUF_SIZE) + 48);
    }

    public int getVariableBufferOffset(int varBuf) {
        return buffer.getInt((varBuf * VARBUF_SIZE) + 52);
    }

    public int getLatestVariableBufferIndex() {
        int latest = 0;
        for (int i = 1; i < getNumberBuffer(); i++) {
            if (getTickCount(latest) < getTickCount(i)) {
                latest = i;
            }
        }
        return latest;
    }

}
