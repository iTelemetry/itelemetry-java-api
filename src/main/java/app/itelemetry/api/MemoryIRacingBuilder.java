package app.itelemetry.api;

public class MemoryIRacingBuilder implements IRacingBuilder {

    @Override
    public IRacingService build() {
        return new MemoryIRacingService();
    }

}
