package app.itelemetry.api;

import app.itelemetry.api.iracing.memory.MemoryMap;

public class MemoryIRacingBuilder implements IRacingBuilder<MemoryIRacingBuilder, MemoryIRacingService> {

    private MemoryMap map;

    public MemoryIRacingBuilder(MemoryMap map) {
        this.map = map;
    }

    @Override
    public MemoryIRacingBuilder withMemoryMap(MemoryMap map) {
        this.map = map;
        return this;
    }

    @Override
    public MemoryIRacingService build() {
        return new MemoryIRacingService(map);
    }

}
