package app.itelemetry.api.session;

import app.itelemetry.api.iracing.yml.IRSessionType;

import java.time.ZonedDateTime;

public interface Session {

    /*
     * SessionNum: %d
     * SessionLaps: %d
     * SessionTime: %0.2f sec
     * SessionNumLapsToAvg: %d
     * SessionType: %s
     * SessionTrackRubberState: %s
     */

    int getUid();

    int getNumber();

    SessionFlags getFlags();

    int getLaps();

    int getLapsRemaining();

    ZonedDateTime getStartTime();

    double getRunningTime();

    double getTimeRemaining();

    int getLapsToAverage();

    IRSessionType getType();

}
