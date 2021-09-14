package app.itelemetry.api;

import app.itelemetry.api.iracing.memory.MemoryMap;

public interface IRacingBuilder<T extends IRacingBuilder<?, R>, R extends IRacingService> {

    T withMemoryMap(MemoryMap map);

    R build();

}
