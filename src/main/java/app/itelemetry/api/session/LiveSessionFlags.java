package app.itelemetry.api.session;

import app.itelemetry.api.iracing.memory.MemoryMap;

public class LiveSessionFlags extends AbsSessionFlags {

    private final MemoryMap map;

    public LiveSessionFlags(MemoryMap map) {
        this.map = map;
    }

    @Override
    public int getValue() {
        return getCurrentValue(map);
    }

    public static int getCurrentValue(MemoryMap map) {
        return (int) map.getHeader("SessionFlags").getValue();
    }

}
