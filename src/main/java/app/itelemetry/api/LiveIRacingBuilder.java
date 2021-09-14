package app.itelemetry.api;

public class LiveIRacingBuilder implements IRacingBuilder {

    @Override
    public IRacingService build() {
        return new LiveIRacingService();
    }

}
