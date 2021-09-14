package app.itelemetry.api.session;

import app.itelemetry.client.iracing.yml.IRSession;
import app.itelemetry.data.messages.protos.SessionType;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import static app.itelemetry.client.iracing.memory.MemoryMapImpl.MAP;

public class LiveSession implements Session {

    private IRSession getIRSession() {
        return MAP.getData().getSessionInfo().getSessions().get(getNumber());
    }

    @Override
    public int getUid() {
        return (int) MAP.getHeader("SessionUniqueId").getValue();
    }

    @Override
    public int getNumber() {
        return (int) MAP.getHeader("SessionNum").getValue();
    }

    @Override
    public SessionFlags getFlags() {
        return new LiveSessionFlags();
    }

    @Override
    public int getLaps() {
        return Integer.parseInt(getIRSession().getSessionLaps());
    }

    @Override
    public int getLapsRemaining() {
        return (int) MAP.getHeader("SessionLapsRemain").getValue();
    }

    @Override
    public ZonedDateTime getStartTime() {
        Double sessionTime = (Double) MAP.getHeader("SessionTime").getValue();

        long sessionNanos = Math.round(sessionTime * 1e+9);
        return ZonedDateTime.now(ZoneId.systemDefault()).minusNanos(sessionNanos);
    }

    @Override
    public double getRunningTime() {
        return (Double) MAP.getHeader("SessionTime").getValue();
    }

    @Override
    public double getTimeRemaining() {
        return (Double) MAP.getHeader("SessionTimeRemain").getValue();
    }

    @Override
    public int getLapsToAverage() {
        return getIRSession().getSessionNumLapsToAvg();
    }

    @Override
    public SessionType getType() {
        IRSession session = getIRSession();
        SessionType sessionType = SessionType.UNKNOWN_TYPE;
        if (session.getSessionType().toLowerCase().contains("practice")) {
            sessionType = SessionType.PRACTICE;
        } else if (session.getSessionType().toLowerCase().contains("qualify")) {
            sessionType = SessionType.QUALIFY;
        } else if (session.getSessionType().toLowerCase().contains("race")) {
            sessionType = SessionType.RACE;
        }

        return sessionType;
    }

}
