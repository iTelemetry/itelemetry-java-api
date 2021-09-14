package app.itelemetry.api.session;

import app.itelemetry.api.iracing.memory.MemoryMap;

public class MemorySessionFlags extends AbsSessionFlags {

    private final int value;

    public MemorySessionFlags(MemoryMap map) {
        this(LiveSessionFlags.getCurrentValue(map));
    }

    public MemorySessionFlags(int value) {
        this.value = value;
    }

    public MemorySessionFlags(SessionFlags flags) {
        this.value = flags.getValue();
    }

    @Override
    public int getValue() {
        return value;
    }

}
