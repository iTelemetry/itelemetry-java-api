package app.itelemetry.api.iracing.config;

public class MemoryMapConfig {

    private final int fileRefreshInterval;
    private final int collectFrequency;

    public MemoryMapConfig(int fileRefreshInterval, int collectFrequency) {
        this.fileRefreshInterval = fileRefreshInterval;
        this.collectFrequency = collectFrequency;
    }

    public int getFileRefreshInterval() {
        return fileRefreshInterval;
    }

    public int getCollectFrequency() {
        return collectFrequency;
    }

}
