package app.itelemetry.api.session;

import static app.itelemetry.client.iracing.memory.MemoryMapImpl.MAP;

public class LiveSessionFlags extends AbsSessionFlags {

    @Override
    public int getValue() {
        return getCurrentValue();
    }

    public static int getCurrentValue() {
        return (int) MAP.getHeader("SessionFlags").getValue();
    }

}
