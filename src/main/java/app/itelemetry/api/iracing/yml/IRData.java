package app.itelemetry.api.iracing.yml;

public class IRData {

    private IRWeekendInfo weekendInfo;
    private IRDriverInfo driverInfo;
    private IRQualifyResultsInfo qualifyResultsInfo;
    private IRSessionInfo sessionInfo;

    public IRWeekendInfo getWeekendInfo() {
        return weekendInfo;
    }

    public void setWeekendInfo(IRWeekendInfo weekendInfo) {
        this.weekendInfo = weekendInfo;
    }

    public IRDriverInfo getDriverInfo() {
        return driverInfo;
    }

    public void setDriverInfo(IRDriverInfo driverInfo) {
        this.driverInfo = driverInfo;
    }

    public IRQualifyResultsInfo getQualifyResultsInfo() {
        return qualifyResultsInfo;
    }

    public void setQualifyResultsInfo(IRQualifyResultsInfo qualifyResultsInfo) {
        this.qualifyResultsInfo = qualifyResultsInfo;
    }

    public IRSessionInfo getSessionInfo() {
        return sessionInfo;
    }

    public void setSessionInfo(IRSessionInfo sessionInfo) {
        this.sessionInfo = sessionInfo;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("IRData{");
        sb.append("weekendInfo=").append(weekendInfo);
        sb.append(", driverInfo=").append(driverInfo);
        sb.append(", qualifyResultsInfo=").append(qualifyResultsInfo);
        sb.append(", sessionInfo=").append(sessionInfo);
        sb.append('}');
        return sb.toString();
    }

}
