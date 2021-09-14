package app.itelemetry.api;

import app.itelemetry.api.iracing.memory.MemoryMap;
import app.itelemetry.api.session.LiveSession;
import app.itelemetry.api.session.Session;
import app.itelemetry.api.weekend.LiveWeekend;
import app.itelemetry.api.weekend.Weekend;

public class LiveIRacingService implements IRacingService {

    private final MemoryMap map;

    public LiveIRacingService(MemoryMap map) {
        this.map = map;
    }

    @Override
    public Weekend getWeekend() {
        return new LiveWeekend(map);
    }

    @Override
    public Session getSession() {
        return new LiveSession(map);
    }

}
