package app.itelemetry.api.session;

import app.itelemetry.api.iracing.memory.MemoryMap;
import app.itelemetry.api.iracing.yml.IRSession;
import app.itelemetry.api.iracing.yml.IRSessionType;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class LiveSession implements Session {

    private final MemoryMap map;

    public LiveSession(MemoryMap map) {
        this.map = map;
    }

    private IRSession getIRSession() {
        return map.getData().getSessionInfo().getSessions().get(getNumber());
    }

    @Override
    public int getUid() {
        return (int) map.getHeader("SessionUniqueId").getValue();
    }

    @Override
    public int getNumber() {
        return (int) map.getHeader("SessionNum").getValue();
    }

    @Override
    public SessionFlags getFlags() {
        return new LiveSessionFlags(map);
    }

    @Override
    public int getLaps() {
        return Integer.parseInt(getIRSession().getSessionLaps());
    }

    @Override
    public int getLapsRemaining() {
        return (int) map.getHeader("SessionLapsRemain").getValue();
    }

    @Override
    public ZonedDateTime getStartTime() {
        Double sessionTime = (Double) map.getHeader("SessionTime").getValue();

        long sessionNanos = Math.round(sessionTime * 1e+9);
        return ZonedDateTime.now(ZoneId.systemDefault()).minusNanos(sessionNanos);
    }

    @Override
    public double getRunningTime() {
        return (Double) map.getHeader("SessionTime").getValue();
    }

    @Override
    public double getTimeRemaining() {
        return (Double) map.getHeader("SessionTimeRemain").getValue();
    }

    @Override
    public int getLapsToAverage() {
        return getIRSession().getSessionNumLapsToAvg();
    }

    @Override
    public IRSessionType getType() {
        IRSession session = getIRSession();
        IRSessionType sessionType = IRSessionType.UNKNOWN;
        if (session.getSessionType().toLowerCase().contains("practice")) {
            sessionType = IRSessionType.PRACTICE;
        } else if (session.getSessionType().toLowerCase().contains("qualify")) {
            sessionType = IRSessionType.QUALIFY;
        } else if (session.getSessionType().toLowerCase().contains("race")) {
            sessionType = IRSessionType.RACE;
        }

        return sessionType;
    }

}
