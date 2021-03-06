package app.itelemetry.api;

import app.itelemetry.api.iracing.memory.MemoryMap;
import app.itelemetry.api.session.LiveSession;
import app.itelemetry.api.session.MemorySession;
import app.itelemetry.api.session.Session;
import app.itelemetry.api.weekend.LiveWeekend;
import app.itelemetry.api.weekend.MemoryWeekend;
import app.itelemetry.api.weekend.Weekend;

public class MemoryIRacingService implements IRacingService {

    private final MemoryMap map;

    public MemoryIRacingService(MemoryMap map) {
        this.map = map;
    }

    @Override
    public Weekend getWeekend() {
        return new MemoryWeekend(new LiveWeekend(map));
    }

    @Override
    public Session getSession() {
        return new MemorySession(new LiveSession(map));
    }

}
