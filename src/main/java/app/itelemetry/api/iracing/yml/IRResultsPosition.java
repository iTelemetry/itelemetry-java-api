package app.itelemetry.api.iracing.yml;

public class IRResultsPosition {

    private int position;
    private int classPosition;
    private int carIdx;
    private int lap;
    private float time;
    private int fastestLap;
    private float fastestTime;
    private float lastTime;
    private int lapsLed;
    private int lapsComplete;
    private float lapsDriven;
    private int incidents;
    private int reasonOutId;
    private String reasonOutStr;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getClassPosition() {
        return classPosition;
    }

    public void setClassPosition(int classPosition) {
        this.classPosition = classPosition;
    }

    public int getCarIdx() {
        return carIdx;
    }

    public void setCarIdx(int carIdx) {
        this.carIdx = carIdx;
    }

    public int getLap() {
        return lap;
    }

    public void setLap(int lap) {
        this.lap = lap;
    }

    public float getTime() {
        return time;
    }

    public void setTime(float time) {
        this.time = time;
    }

    public int getFastestLap() {
        return fastestLap;
    }

    public void setFastestLap(int fastestLap) {
        this.fastestLap = fastestLap;
    }

    public float getFastestTime() {
        return fastestTime;
    }

    public void setFastestTime(float fastestTime) {
        this.fastestTime = fastestTime;
    }

    public float getLastTime() {
        return lastTime;
    }

    public void setLastTime(float lastTime) {
        this.lastTime = lastTime;
    }

    public int getLapsLed() {
        return lapsLed;
    }

    public void setLapsLed(int lapsLed) {
        this.lapsLed = lapsLed;
    }

    public int getLapsComplete() {
        return lapsComplete;
    }

    public void setLapsComplete(int lapsComplete) {
        this.lapsComplete = lapsComplete;
    }

    public float getLapsDriven() {
        return lapsDriven;
    }

    public void setLapsDriven(float lapsDriven) {
        this.lapsDriven = lapsDriven;
    }

    public int getIncidents() {
        return incidents;
    }

    public void setIncidents(int incidents) {
        this.incidents = incidents;
    }

    public int getReasonOutId() {
        return reasonOutId;
    }

    public void setReasonOutId(int reasonOutId) {
        this.reasonOutId = reasonOutId;
    }

    public String getReasonOutStr() {
        return reasonOutStr;
    }

    public void setReasonOutStr(String reasonOutStr) {
        this.reasonOutStr = reasonOutStr;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("IRResultsPositions{");
        sb.append("position=").append(position);
        sb.append(", classPosition=").append(classPosition);
        sb.append(", carIdx=").append(carIdx);
        sb.append(", lap=").append(lap);
        sb.append(", time=").append(time);
        sb.append(", fastestLap=").append(fastestLap);
        sb.append(", fastestTime=").append(fastestTime);
        sb.append(", lastTime=").append(lastTime);
        sb.append(", lapsLed=").append(lapsLed);
        sb.append(", lapsComplete=").append(lapsComplete);
        sb.append(", lapsDriven=").append(lapsDriven);
        sb.append(", incidents=").append(incidents);
        sb.append(", reasonOutId=").append(reasonOutId);
        sb.append(", reasonOutStr='").append(reasonOutStr).append('\'');
        sb.append('}');
        return sb.toString();
    }

}
