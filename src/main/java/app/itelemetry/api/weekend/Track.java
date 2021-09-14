package app.itelemetry.api.weekend;

public interface Track {

    /*
     * TrackName: %s
     * TrackID: %d
     * TrackLength: %0.2f km
     * TrackDisplayName: %s
     * TrackDisplayShortName: %s
     * TrackConfigName: %s
     * TrackCity: %s
     * TrackCountry: %s
     * TrackAltitude: %0.2f m
     * TrackLatitude: %0.6f m
     * TrackLongitude: %0.6f m
     * TrackNorthOffset: %0.4f rad
     * TrackNumTurns: %d
     * TrackPitSpeedLimit: %0.2f kph
     * TrackType: %s
     * TrackWeatherType: %s
     * TrackSkies: %s
     * TrackSurfaceTemp: %0.2f C
     * TrackAirTemp: %0.2f C
     * TrackAirPressure: %0.2f Hg
     * TrackWindVel: %0.2f m/s
     * TrackWindDir: %0.2f rad
     * TrackRelativeHumidity: %d %
     * TrackFogLevel: %d %
     * TrackCleanup: %d
     * TrackDynamicTrack: %d
     */

    String getName();

    int getId();

    float getLength();

    String getDisplayName();

    String getShortDisplayName();

    String getConfigurationName();

    String getCity();

    String getCountry();

    float getAltitude();

    float getLatitude();

    float getLongitude();

    float getNorthOffset();

    int getNumberOfTurns();

    float getPitSpeedLimit();

    String getType();

    String getWeatherType();

    String getSkies();

    float getStartFinishTemperature();

    float getCrewTemperature();

    float getSurfaceTemperature();

    float getAirTemperature();

    float getAirPressure();

    float getWindVelocity();

    float getWindDirection();

    float getRelativeHumidity();

    float getFogLevel();

    int getCleanup();

    int getDynamicTrack();

    String getRubberState();

}
