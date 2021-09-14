package app.itelemetry.api.iracing.memory;

import app.itelemetry.api.iracing.header.FileHeader;
import app.itelemetry.api.iracing.header.VariableHeader;
import app.itelemetry.api.iracing.yml.IRData;

public interface MemoryMap {

    boolean isConnected();

    int getSimStatus();

    int getStatus();

    FileHeader getFileHeader();

    VariableHeader getHeader(String name);

    int getDriverHeaderInt(String name, int carIdx);

    float getDriverHeaderFloat(String name, int carIdx);

    boolean getDriverHeaderBoolean(String name, int carIdx);

    boolean isRelativeUpdate();

    IRData getData();

}
