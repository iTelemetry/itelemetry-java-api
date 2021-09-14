package app.itelemetry.api.iracing.yml;

import java.util.List;

public class IRSessionInfo {

    private int numSessions;
    private List<IRSession> sessions;

    public int getNumSessions() {
        return numSessions;
    }

    public void setNumSessions(int numSessions) {
        this.numSessions = numSessions;
    }

    public List<IRSession> getSessions() {
        return sessions;
    }

    public void setSessions(List<IRSession> sessions) {
        this.sessions = sessions;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("IRSessionInfo{");
        sb.append("numSessions=").append(numSessions);
        sb.append(", sessions=").append(sessions);
        sb.append('}');
        return sb.toString();
    }

}
