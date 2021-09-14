package app.itelemetry.api.iracing.yml;

import java.util.List;

public class IRSession {

    private int sessionNum;
    private String sessionLaps;
    private String sessionTime;
    private int sessionNumLapsToAvg;
    private String sessionType;
    private String sessionTrackRubberState;
    private List<IRResultsPosition> resultsPositions;
    private List<IRResultsFastestLap> resultsFastestLap;
    private float resultsAverageLapTime;
    private int resultsNumCautionFlags;
    private int resultsNumCautionLaps;
    private int resultsNumLeadChanges;
    private int resultsLapsComplete;
    private int resultsOfficial;

    public int getSessionNum() {
        return sessionNum;
    }

    public void setSessionNum(int sessionNum) {
        this.sessionNum = sessionNum;
    }

    public String getSessionLaps() {
        return sessionLaps;
    }

    public void setSessionLaps(String sessionLaps) {
        this.sessionLaps = sessionLaps;
    }

    public String getSessionTime() {
        return sessionTime;
    }

    public void setSessionTime(String sessionTime) {
        this.sessionTime = sessionTime;
    }

    public int getSessionNumLapsToAvg() {
        return sessionNumLapsToAvg;
    }

    public void setSessionNumLapsToAvg(int sessionNumLapsToAvg) {
        this.sessionNumLapsToAvg = sessionNumLapsToAvg;
    }

    public String getSessionType() {
        return sessionType;
    }

    public void setSessionType(String sessionType) {
        this.sessionType = sessionType;
    }

    public String getSessionTrackRubberState() {
        return sessionTrackRubberState;
    }

    public void setSessionTrackRubberState(String sessionTrackRubberState) {
        this.sessionTrackRubberState = sessionTrackRubberState;
    }

    public List<IRResultsPosition> getResultsPositions() {
        return resultsPositions;
    }

    public void setResultsPositions(List<IRResultsPosition> resultsPositions) {
        this.resultsPositions = resultsPositions;
    }

    public List<IRResultsFastestLap> getResultsFastestLap() {
        return resultsFastestLap;
    }

    public void setResultsFastestLap(List<IRResultsFastestLap> resultsFastestLap) {
        this.resultsFastestLap = resultsFastestLap;
    }

    public float getResultsAverageLapTime() {
        return resultsAverageLapTime;
    }

    public void setResultsAverageLapTime(float resultsAverageLapTime) {
        this.resultsAverageLapTime = resultsAverageLapTime;
    }

    public int getResultsNumCautionFlags() {
        return resultsNumCautionFlags;
    }

    public void setResultsNumCautionFlags(int resultsNumCautionFlags) {
        this.resultsNumCautionFlags = resultsNumCautionFlags;
    }

    public int getResultsNumCautionLaps() {
        return resultsNumCautionLaps;
    }

    public void setResultsNumCautionLaps(int resultsNumCautionLaps) {
        this.resultsNumCautionLaps = resultsNumCautionLaps;
    }

    public int getResultsNumLeadChanges() {
        return resultsNumLeadChanges;
    }

    public void setResultsNumLeadChanges(int resultsNumLeadChanges) {
        this.resultsNumLeadChanges = resultsNumLeadChanges;
    }

    public int getResultsLapsComplete() {
        return resultsLapsComplete;
    }

    public void setResultsLapsComplete(int resultsLapsComplete) {
        this.resultsLapsComplete = resultsLapsComplete;
    }

    public int getResultsOfficial() {
        return resultsOfficial;
    }

    public void setResultsOfficial(int resultsOfficial) {
        this.resultsOfficial = resultsOfficial;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("IRSession{");
        sb.append("sessionNum=").append(sessionNum);
        sb.append(", sessionLaps=").append(sessionLaps);
        sb.append(", sessionTime='").append(sessionTime).append('\'');
        sb.append(", sessionNumLapsToAvg=").append(sessionNumLapsToAvg);
        sb.append(", sessionType='").append(sessionType).append('\'');
        sb.append(", sessionTrackRubberState='").append(sessionTrackRubberState).append('\'');
        sb.append(", resultsPositions=").append(resultsPositions);
        sb.append(", resultsFastestLap=").append(resultsFastestLap);
        sb.append(", resultsAverageLapTime=").append(resultsAverageLapTime);
        sb.append(", resultsNumCautionFlags=").append(resultsNumCautionFlags);
        sb.append(", resultsNumCautionLaps=").append(resultsNumCautionLaps);
        sb.append(", resultsNumLeadChanges=").append(resultsNumLeadChanges);
        sb.append(", resultsLapsComplete=").append(resultsLapsComplete);
        sb.append(", resultsOfficial=").append(resultsOfficial);
        sb.append('}');
        return sb.toString();
    }

}
