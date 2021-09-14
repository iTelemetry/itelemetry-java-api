package app.itelemetry.api.iracing.yml;

import java.util.List;

public class IRDriverInfo {

    private int driverCarRedLine;
    private int driverCarIdx;

    private List<IRDriver> drivers;

    public int getDriverCarRedLine() {
        return driverCarRedLine;
    }

    public void setDriverCarRedLine(int driverCarRedLine) {
        this.driverCarRedLine = driverCarRedLine;
    }

    public int getDriverCarIdx() {
        return driverCarIdx;
    }

    public void setDriverCarIdx(int driverCarIdx) {
        this.driverCarIdx = driverCarIdx;
    }

    public List<IRDriver> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<IRDriver> drivers) {
        this.drivers = drivers;
    }

}
