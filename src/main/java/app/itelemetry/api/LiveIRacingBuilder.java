package app.itelemetry.api;

import app.itelemetry.api.iracing.memory.MemoryMap;

public class LiveIRacingBuilder implements IRacingBuilder<LiveIRacingBuilder, LiveIRacingService> {

    private MemoryMap map;

    public LiveIRacingBuilder(MemoryMap map) {
        this.map = map;
    }

    @Override
    public LiveIRacingBuilder withMemoryMap(MemoryMap map) {
        this.map = map;
        return this;
    }

    @Override
    public LiveIRacingService build() {
        return new LiveIRacingService(map);
    }

}
