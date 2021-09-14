package app.itelemetry.api.weekend;

import app.itelemetry.api.iracing.memory.MemoryMap;
import app.itelemetry.api.iracing.yml.IRSession;
import app.itelemetry.api.iracing.yml.IRWeekendInfo;

public class LiveTrack implements Track {
    
    private final MemoryMap map;

    public LiveTrack(MemoryMap map) {
        this.map = map;
    }

    private IRSession getIRSession() {
        return map.getData().getSessionInfo().getSessions().get(
                (int) map.getHeader("SessionNum").getValue()
        );
    }

    private IRWeekendInfo getWeekendInfo() {
        return map.getData().getWeekendInfo();
    }

    @Override
    public String getName() {
        return getWeekendInfo().getTrackName();
    }

    @Override
    public int getId() {
        return getWeekendInfo().getTrackId();
    }

    @Override
    public float getLength() {
        return Float.parseFloat(getWeekendInfo().getTrackLength());
    }

    @Override
    public String getDisplayName() {
        return getWeekendInfo().getTrackDisplayName();
    }

    @Override
    public String getShortDisplayName() {
        return getWeekendInfo().getTrackDisplayShortName();
    }

    @Override
    public String getConfigurationName() {
        return getWeekendInfo().getTrackConfigName();
    }

    @Override
    public String getCity() {
        return getWeekendInfo().getTrackCity();
    }

    @Override
    public String getCountry() {
        return getWeekendInfo().getTrackCountry();
    }

    @Override
    public float getAltitude() {
        return Float.parseFloat(getWeekendInfo().getTrackAltitude());
    }

    @Override
    public float getLatitude() {
        return Float.parseFloat(getWeekendInfo().getTrackLatitude());
    }

    @Override
    public float getLongitude() {
        return Float.parseFloat(getWeekendInfo().getTrackLongitude());
    }

    @Override
    public float getNorthOffset() {
        return Float.parseFloat(getWeekendInfo().getTrackNorthOffset());
    }

    @Override
    public int getNumberOfTurns() {
        return getWeekendInfo().getTrackNumTurns();
    }

    @Override
    public float getPitSpeedLimit() {
        return Float.parseFloat(getWeekendInfo().getTrackPitSpeedLimit());
    }

    @Override
    public String getType() {
        return getWeekendInfo().getTrackType();
    }

    @Override
    public String getWeatherType() {
        return getWeekendInfo().getTrackWeatherType();
    }

    @Override
    public String getSkies() {
        return getWeekendInfo().getTrackSkies();
    }

    @Override
    public float getStartFinishTemperature() {
        return (Float) map.getHeader("TrackTemp").getValue();
    }

    @Override
    public float getCrewTemperature() {
        return (Float) map.getHeader("TrackTempCrew").getValue();
    }

    @Override
    public float getSurfaceTemperature() {
        return Float.parseFloat(getWeekendInfo().getTrackSurfaceTemp());
    }

    @Override
    public float getAirTemperature() {
        return Float.parseFloat(getWeekendInfo().getTrackAirTemp());
    }

    @Override
    public float getAirPressure() {
        return Float.parseFloat(getWeekendInfo().getTrackAirPressure());
    }

    @Override
    public float getWindVelocity() {
        return Float.parseFloat(getWeekendInfo().getTrackWindVel());
    }

    @Override
    public float getWindDirection() {
        return Float.parseFloat(getWeekendInfo().getTrackWindDir());
    }

    @Override
    public float getRelativeHumidity() {
        return Float.parseFloat(getWeekendInfo().getTrackRelativeHumidity());
    }

    @Override
    public float getFogLevel() {
        return Float.parseFloat(getWeekendInfo().getTrackFogLevel());
    }

    @Override
    public int getCleanup() {
        return getWeekendInfo().getTrackCleanup();
    }

    @Override
    public int getDynamicTrack() {
        return getWeekendInfo().getTrackDynamicTrack();
    }

    @Override
    public String getRubberState() {
        return getIRSession().getSessionTrackRubberState();
    }

}
