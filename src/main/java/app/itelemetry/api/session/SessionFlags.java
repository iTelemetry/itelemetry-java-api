package app.itelemetry.api.session;

public interface SessionFlags {

    /*
     * irsdk_checkered
     * irsdk_white
     * irsdk_green
     * irsdk_yellow
     * irsdk_red
     * irsdk_blue
     * irsdk_debris
     * irsdk_crossed
     * irsdk_yellowWaving
     * irsdk_oneLapToGreen
     * irsdk_greenHeld
     * irsdk_tenToGo
     * irsdk_fiveToGo
     * irsdk_randomWaving
     * irsdk_caution
     * irsdk_cautionWaving
     * irsdk_black
     * irsdk_disqualify
     * irsdk_servicible
     * irsdk_furled
     * irsdk_repair
     * irsdk_startHidden
     * irsdk_startReady
     * irsdk_startSet
     */

    int getValue();

    boolean isCheckered();

    boolean isWhite();

    boolean isGreen();

    boolean isYellow();

    boolean isRed();

    boolean isBlue();

    boolean isDebris();

    boolean isCrossed();

    boolean isYellowWaving();

    boolean isOneLapToGreen();

    boolean isGreenHeld();

    boolean isTenToGo();

    boolean isFiveToGo();

    boolean isRandomWaving();

    boolean isCaution();

    boolean isCautionWaving();

    boolean isBlack();

    boolean isDisqualify();

    boolean isServiceable();

    boolean isFurled();

    boolean isRepair();

    boolean isStartHidden();

    boolean isStartReady();

    boolean isStartSet();

}
