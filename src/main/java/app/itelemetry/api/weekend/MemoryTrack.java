package app.itelemetry.api.weekend;

public class MemoryTrack implements Track {
    
    private final Track track;
    
    private String name;
    private int id;
    private float length;
    private String displayName;
    private String shortDisplayName;
    private String configurationName;
    private String city;
    private String country;
    private float altitude;
    private float latitude;
    private float longitude;
    private float northOffset;
    private int numberOfTurns;
    private float pitSpeedLimit;
    private String type;
    private String weatherType;
    private String skies;
    private float startFinishTemperature;
    private float crewTemperature;
    private float surfaceTemperature;
    private float airTemperature;
    private float airPressure;
    private float windVelocity;
    private float windDirection;
    private float relativeHumidity;
    private float fogLevel;
    private int cleanup;
    private int dynamicTrack;
    private String rubberState;

    public MemoryTrack(Track track) {
        this.track = track;
        update();
    }
    
    private void update() {
        setName(track.getName());
        setId(track.getId());
        setLength(track.getLength());
        setDisplayName(track.getDisplayName());
        setShortDisplayName(track.getShortDisplayName());
        setConfigurationName(track.getConfigurationName());
        setCity(track.getCity());
        setCountry(track.getCountry());
        setAltitude(track.getAltitude());
        setLatitude(track.getLatitude());
        setLongitude(track.getLongitude());
        setNorthOffset(track.getNorthOffset());
        setNumberOfTurns(track.getNumberOfTurns());
        setPitSpeedLimit(track.getPitSpeedLimit());
        setType(track.getType());
        setWeatherType(track.getWeatherType());
        setSkies(track.getSkies());
        setStartFinishTemperature(track.getStartFinishTemperature());
        setCrewTemperature(track.getCrewTemperature());
        setSurfaceTemperature(track.getSurfaceTemperature());
        setAirTemperature(track.getAirTemperature());
        setAirPressure(track.getAirPressure());
        setWindVelocity(track.getWindVelocity());
        setWindDirection(track.getWindDirection());
        setRelativeHumidity(track.getRelativeHumidity());
        setFogLevel(track.getFogLevel());
        setCleanup(track.getCleanup());
        setDynamicTrack(track.getDynamicTrack());
        setRubberState(track.getRubberState());
    }

    public Track getTrack() {
        return track;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    @Override
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String getShortDisplayName() {
        return shortDisplayName;
    }

    public void setShortDisplayName(String shortDisplayName) {
        this.shortDisplayName = shortDisplayName;
    }

    @Override
    public String getConfigurationName() {
        return configurationName;
    }

    public void setConfigurationName(String configurationName) {
        this.configurationName = configurationName;
    }

    @Override
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public float getAltitude() {
        return altitude;
    }

    public void setAltitude(float altitude) {
        this.altitude = altitude;
    }

    @Override
    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    @Override
    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    @Override
    public float getNorthOffset() {
        return northOffset;
    }

    public void setNorthOffset(float northOffset) {
        this.northOffset = northOffset;
    }

    @Override
    public int getNumberOfTurns() {
        return numberOfTurns;
    }

    public void setNumberOfTurns(int numberOfTurns) {
        this.numberOfTurns = numberOfTurns;
    }

    @Override
    public float getPitSpeedLimit() {
        return pitSpeedLimit;
    }

    public void setPitSpeedLimit(float pitSpeedLimit) {
        this.pitSpeedLimit = pitSpeedLimit;
    }

    @Override
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getWeatherType() {
        return weatherType;
    }

    public void setWeatherType(String weatherType) {
        this.weatherType = weatherType;
    }

    @Override
    public String getSkies() {
        return skies;
    }

    public void setSkies(String skies) {
        this.skies = skies;
    }

    @Override
    public float getStartFinishTemperature() {
        return startFinishTemperature;
    }

    public void setStartFinishTemperature(float startFinishTemperature) {
        this.startFinishTemperature = startFinishTemperature;
    }

    @Override
    public float getCrewTemperature() {
        return crewTemperature;
    }

    public void setCrewTemperature(float crewTemperature) {
        this.crewTemperature = crewTemperature;
    }

    @Override
    public float getSurfaceTemperature() {
        return surfaceTemperature;
    }

    public void setSurfaceTemperature(float surfaceTemperature) {
        this.surfaceTemperature = surfaceTemperature;
    }

    @Override
    public float getAirTemperature() {
        return airTemperature;
    }

    public void setAirTemperature(float airTemperature) {
        this.airTemperature = airTemperature;
    }

    @Override
    public float getAirPressure() {
        return airPressure;
    }

    public void setAirPressure(float airPressure) {
        this.airPressure = airPressure;
    }

    @Override
    public float getWindVelocity() {
        return windVelocity;
    }

    public void setWindVelocity(float windVelocity) {
        this.windVelocity = windVelocity;
    }

    @Override
    public float getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(float windDirection) {
        this.windDirection = windDirection;
    }

    @Override
    public float getRelativeHumidity() {
        return relativeHumidity;
    }

    public void setRelativeHumidity(float relativeHumidity) {
        this.relativeHumidity = relativeHumidity;
    }

    @Override
    public float getFogLevel() {
        return fogLevel;
    }

    public void setFogLevel(float fogLevel) {
        this.fogLevel = fogLevel;
    }

    @Override
    public int getCleanup() {
        return cleanup;
    }

    public void setCleanup(int cleanup) {
        this.cleanup = cleanup;
    }

    @Override
    public int getDynamicTrack() {
        return dynamicTrack;
    }

    public void setDynamicTrack(int dynamicTrack) {
        this.dynamicTrack = dynamicTrack;
    }

    @Override
    public String getRubberState() {
        return rubberState;
    }

    public void setRubberState(String rubberState) {
        this.rubberState = rubberState;
    }

}
