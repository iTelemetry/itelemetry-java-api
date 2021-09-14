package app.itelemetry.api.iracing.yml;

import java.util.List;

public class IRQualifyResultsInfo {

    private List<IRQualifyResultInfo> results;

    public List<IRQualifyResultInfo> getResults() {
        return results;
    }

    public void setResults(List<IRQualifyResultInfo> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("IRQualifyResultsInfo{");
        sb.append("results=").append(results);
        sb.append('}');
        return sb.toString();
    }

}
