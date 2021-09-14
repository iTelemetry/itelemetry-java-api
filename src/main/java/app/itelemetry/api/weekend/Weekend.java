package app.itelemetry.api.weekend;

public interface Weekend {

    /*
     * SeriesID: %d
     * SeasonID: %d
     * SessionID: %d
     * SubSessionID: %d
     * LeagueID: %d
     * Official: %d
     * RaceWeek: %d
     * EventType: %s
     * Category: %s
     * SimMode: %s
     * TeamRacing: %d
     * MinDrivers: %d
     * MaxDrivers: %d
     * DCRuleSet: %s
     * QualifierMustStartRace: %d
     * NumCarClasses: %d
     * NumCarTypes: %d
     */

    int getSeriesId();

    int getSeasonId();

    int getSessionId();

    int getSubSessionId();

    int getLeagueId();

    boolean isOfficial();

    int getRaceWeek();

    String getEventType();

    String getCategory();

    String getSimMode();

    boolean isTeamRacing();

    int getMinDrivers();

    int getMaxDrivers();

    String getDriverChangeRules();

    boolean isQualifierStart();

    int getCarClasses();

    int getCarTypes();

    Track getTrack();

}
