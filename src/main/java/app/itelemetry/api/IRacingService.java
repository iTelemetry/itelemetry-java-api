package app.itelemetry.api;

import app.itelemetry.api.session.Session;
import app.itelemetry.api.weekend.Weekend;

public interface IRacingService {

    Weekend getWeekend();

    Session getSession();

}
