package app.itelemetry.api.iracing.header;

import java.nio.ByteBuffer;

public enum HeaderType {

    IRSDK_CHAR(1) {
        @Override
        public Character getValue(ByteBuffer updateBuffer, VariableHeader header) {
            return updateBuffer.getChar(header.getOffset());
        }
    },
    IRSDK_BOOLEAN(1) {
        @Override
        public Boolean getValue(ByteBuffer updateBuffer, VariableHeader header) {
            return updateBuffer.get(header.getOffset()) == 1;
        }
    },
    IRSDK_INT(4) {
        @Override
        public Integer getValue(ByteBuffer updateBuffer, VariableHeader header) {
            return updateBuffer.getInt(header.getOffset());
        }
    },
    IRSDK_BIT_FIELD(4) {
        @Override
        public Object getValue(ByteBuffer updateBuffer, VariableHeader header) {
            return null;
        }
    },
    IRSDK_FLOAT(4) {
        @Override
        public Float getValue(ByteBuffer updateBuffer, VariableHeader header) {
            return updateBuffer.getFloat(header.getOffset());
        }
    },
    IRSDK_DOUBLE(8) {
        @Override
        public Double getValue(ByteBuffer updateBuffer, VariableHeader header) {
            return updateBuffer.getDouble(header.getOffset());
        }
    },
    IRSDK_ET_COUNT {
        @Override
        public Object getValue(ByteBuffer updateBuffer, VariableHeader header) {
            return null;
        }
    };

    private final int bytes;

    HeaderType() {
        this(-1);
    }

    HeaderType(int bytes) {
        this.bytes = bytes;
    }

    public int getBytes() {
        return bytes;
    }

    public Object getValue(VariableHeader header) {
        return getValue(header.getBuffer(), header);
    }

    public abstract Object getValue(ByteBuffer updateBuffer, VariableHeader header);

}
