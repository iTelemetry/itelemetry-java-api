package app.itelemetry.api.weekend;

public class MemoryWeekend implements Weekend {

    private final Weekend weekend;
    
    private int seriesId;
    private int seasonId;
    private int sessionId;
    private int subSessionId;
    private int leagueId;
    private boolean official;
    private int raceWeek;
    private String eventType;
    private String category;
    private String simMode;
    private boolean teamRacing;
    private int minDrivers;
    private int maxDrivers;
    private String driverChangeRules;
    private boolean qualifierStart;
    private int carClasses;
    private int carTypes;
    private Track track;

    public MemoryWeekend(Weekend weekend) {
        this.weekend = weekend;
        update();
    }
    
    private void update() {
        setSeriesId(weekend.getSeriesId());
        setSeasonId(weekend.getSeasonId());
        setSessionId(weekend.getSessionId());
        setSubSessionId(weekend.getSubSessionId());
        setLeagueId(weekend.getLeagueId());
        setOfficial(weekend.isOfficial());
        setRaceWeek(weekend.getRaceWeek());
        setEventType(weekend.getEventType());
        setCategory(weekend.getCategory());
        setSimMode(weekend.getSimMode());
        setTeamRacing(weekend.isTeamRacing());
        setMinDrivers(weekend.getMinDrivers());
        setMaxDrivers(weekend.getMaxDrivers());
        setDriverChangeRules(weekend.getDriverChangeRules());
        setQualifierStart(weekend.isQualifierStart());
        setCarClasses(weekend.getCarClasses());
        setCarTypes(weekend.getCarTypes());
        setTrack(new MemoryTrack(weekend.getTrack()));
    }

    public Weekend getWeekend() {
        return weekend;
    }

    @Override
    public int getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(int seriesId) {
        this.seriesId = seriesId;
    }

    @Override
    public int getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(int seasonId) {
        this.seasonId = seasonId;
    }

    @Override
    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    @Override
    public int getSubSessionId() {
        return subSessionId;
    }

    public void setSubSessionId(int subSessionId) {
        this.subSessionId = subSessionId;
    }

    @Override
    public int getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(int leagueId) {
        this.leagueId = leagueId;
    }

    @Override
    public boolean isOfficial() {
        return official;
    }

    public void setOfficial(boolean official) {
        this.official = official;
    }

    @Override
    public int getRaceWeek() {
        return raceWeek;
    }

    public void setRaceWeek(int raceWeek) {
        this.raceWeek = raceWeek;
    }

    @Override
    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    @Override
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String getSimMode() {
        return simMode;
    }

    public void setSimMode(String simMode) {
        this.simMode = simMode;
    }

    @Override
    public boolean isTeamRacing() {
        return teamRacing;
    }

    public void setTeamRacing(boolean teamRacing) {
        this.teamRacing = teamRacing;
    }

    @Override
    public int getMinDrivers() {
        return minDrivers;
    }

    public void setMinDrivers(int minDrivers) {
        this.minDrivers = minDrivers;
    }

    @Override
    public int getMaxDrivers() {
        return maxDrivers;
    }

    public void setMaxDrivers(int maxDrivers) {
        this.maxDrivers = maxDrivers;
    }

    @Override
    public String getDriverChangeRules() {
        return driverChangeRules;
    }

    public void setDriverChangeRules(String driverChangeRules) {
        this.driverChangeRules = driverChangeRules;
    }

    @Override
    public boolean isQualifierStart() {
        return qualifierStart;
    }

    public void setQualifierStart(boolean qualifierStart) {
        this.qualifierStart = qualifierStart;
    }

    @Override
    public int getCarClasses() {
        return carClasses;
    }

    public void setCarClasses(int carClasses) {
        this.carClasses = carClasses;
    }

    @Override
    public int getCarTypes() {
        return carTypes;
    }

    public void setCarTypes(int carTypes) {
        this.carTypes = carTypes;
    }

    @Override
    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }
}
