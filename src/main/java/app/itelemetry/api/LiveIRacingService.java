package app.itelemetry.api;

import app.itelemetry.api.session.LiveSession;
import app.itelemetry.api.session.Session;
import app.itelemetry.api.weekend.LiveWeekend;
import app.itelemetry.api.weekend.Weekend;

public class LiveIRacingService implements IRacingService {

    @Override
    public Weekend getWeekend() {
        return new LiveWeekend();
    }

    @Override
    public Session getSession() {
        return new LiveSession();
    }

}
