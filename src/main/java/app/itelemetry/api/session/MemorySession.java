package app.itelemetry.api.session;

import app.itelemetry.data.messages.protos.SessionType;

import java.time.ZonedDateTime;

public class MemorySession implements Session {

    private final Session session;

    private int uid;
    private int number;
    private SessionFlags flags;
    private int laps;
    private int lapsRemaining;
    private ZonedDateTime startTime;
    private double runningTime;
    private double timeRemaining;
    private int lapsToAverage;
    private SessionType type;

    public MemorySession(Session session) {
        this.session = session;
        update();
    }
    
    private void update() {
        setUid(session.getUid());
        setNumber(session.getNumber());
        setFlags(new MemorySessionFlags(session.getFlags()));
        setLaps(session.getLaps());
        setLapsRemaining(session.getLapsRemaining());
        setStartTime(session.getStartTime());
        setRunningTime(session.getRunningTime());
        setTimeRemaining(session.getTimeRemaining());
        setLapsToAverage(session.getLapsToAverage());
        setType(session.getType());
    }

    public Session getSession() {
        return session;
    }

    @Override
    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Override
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public SessionFlags getFlags() {
        return flags;
    }

    public void setFlags(SessionFlags flags) {
        this.flags = flags;
    }

    @Override
    public int getLaps() {
        return laps;
    }

    public void setLaps(int laps) {
        this.laps = laps;
    }

    @Override
    public int getLapsRemaining() {
        return lapsRemaining;
    }

    public void setLapsRemaining(int lapsRemaining) {
        this.lapsRemaining = lapsRemaining;
    }

    @Override
    public ZonedDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(ZonedDateTime startTime) {
        this.startTime = startTime;
    }

    @Override
    public double getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(double runningTime) {
        this.runningTime = runningTime;
    }

    @Override
    public double getTimeRemaining() {
        return timeRemaining;
    }

    public void setTimeRemaining(double timeRemaining) {
        this.timeRemaining = timeRemaining;
    }

    @Override
    public int getLapsToAverage() {
        return lapsToAverage;
    }

    public void setLapsToAverage(int lapsToAverage) {
        this.lapsToAverage = lapsToAverage;
    }

    @Override
    public SessionType getType() {
        return type;
    }

    public void setType(SessionType type) {
        this.type = type;
    }

}
