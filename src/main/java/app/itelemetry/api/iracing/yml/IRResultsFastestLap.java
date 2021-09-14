package app.itelemetry.api.iracing.yml;

public class IRResultsFastestLap {

    private int carIdx;
    private int fastestLap;
    private float fastestTime;

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
        final StringBuilder sb = new StringBuilder("IRResultsFastestLap{");
        sb.append("carIdx=").append(carIdx);
        sb.append(", fastestLap=").append(fastestLap);
        sb.append(", fastestTime=").append(fastestTime);
        sb.append('}');
        return sb.toString();
    }

}
