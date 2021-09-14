package app.itelemetry.api.iracing.yml;

public class IRQualifyResultInfo {

    private int position;
    private int classPosition;
    private int carIdx;
    private int fastestLap;
    private float fastestTime;

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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("IRQualifyResultInfo{");
        sb.append("position=").append(position);
        sb.append(", classPosition=").append(classPosition);
        sb.append(", carIdx=").append(carIdx);
        sb.append(", fastestLap=").append(fastestLap);
        sb.append(", fastestTime=").append(fastestTime);
        sb.append('}');
        return sb.toString();
    }

}
