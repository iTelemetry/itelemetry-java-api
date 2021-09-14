package app.itelemetry.api.weekend;

import app.itelemetry.api.iracing.memory.MemoryMap;
import app.itelemetry.api.iracing.yml.IRWeekendInfo;

public class LiveWeekend implements Weekend {
    
    private final MemoryMap map;

    public LiveWeekend(MemoryMap map) {
        this.map = map;
    }

    private IRWeekendInfo getWeekendInfo() {
        return map.getData().getWeekendInfo();
    }

    @Override
    public int getSeriesId() {
        return getWeekendInfo().getSeriesId();
    }

    @Override
    public int getSeasonId() {
        return getWeekendInfo().getSeasonId();
    }

    @Override
    public int getSessionId() {
        return getWeekendInfo().getSessionId();
    }

    @Override
    public int getSubSessionId() {
        return getWeekendInfo().getSubsessionId();
    }

    @Override
    public int getLeagueId() {
        return getWeekendInfo().getLeagueId();
    }

    @Override
    public boolean isOfficial() {
        return getWeekendInfo().getOfficial() == 1;
    }

    @Override
    public int getRaceWeek() {
        return getWeekendInfo().getRaceWeek();
    }

    @Override
    public String getEventType() {
        return getWeekendInfo().getEventType();
    }

    @Override
    public String getCategory() {
        return getWeekendInfo().getCategory();
    }

    @Override
    public String getSimMode() {
        return getWeekendInfo().getSimMode();
    }

    @Override
    public boolean isTeamRacing() {
        return getWeekendInfo().getTeamRacing() == 1;
    }

    @Override
    public int getMinDrivers() {
        return getWeekendInfo().getMinDrivers();
    }

    @Override
    public int getMaxDrivers() {
        return getWeekendInfo().getMaxDrivers();
    }

    @Override
    public String getDriverChangeRules() {
        return getWeekendInfo().getDcRuleSet();
    }

    @Override
    public boolean isQualifierStart() {
        return getWeekendInfo().getQualifierMustStartRace() == 1;
    }

    @Override
    public int getCarClasses() {
        return getWeekendInfo().getNumCarClasses();
    }

    @Override
    public int getCarTypes() {
        return getWeekendInfo().getNumCarTypes();
    }

    @Override
    public Track getTrack() {
        return new LiveTrack(map);
    }

}
