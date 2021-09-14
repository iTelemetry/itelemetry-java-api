package app.itelemetry.api.iracing.config;

public class MemoryMapConfigBuilder {

    private int fileRefreshInterval;
    private int collectFrequency;

    public MemoryMapConfigBuilder withFileRefreshInterval(int fileRefreshInterval) {
        this.fileRefreshInterval = fileRefreshInterval;
        return this;
    }

    public MemoryMapConfigBuilder withCollectFrequency(int collectFrequency) {
        this.collectFrequency = collectFrequency;
        return this;
    }

    public MemoryMapConfig build() {
        return new MemoryMapConfig(fileRefreshInterval, collectFrequency);
    }

}