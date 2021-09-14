package app.itelemetry.api.session;

public abstract class AbsSessionFlags implements SessionFlags {

    private boolean isFlagSet(int mask) {
        return (getValue() & mask) == mask;
    }

    @Override
    public boolean isCheckered() {
        return isFlagSet(0x00000001);
    }

    @Override
    public boolean isWhite() {
        return isFlagSet(0x00000002);
    }

    @Override
    public boolean isGreen() {
        return isFlagSet(0x00000004);
    }

    @Override
    public boolean isYellow() {
        return isFlagSet(0x00000008);
    }

    @Override
    public boolean isRed() {
        return isFlagSet(0x00000010);
    }

    @Override
    public boolean isBlue() {
        return isFlagSet(0x00000020);
    }

    @Override
    public boolean isDebris() {
        return isFlagSet(0x00000040);
    }

    @Override
    public boolean isCrossed() {
        return isFlagSet(0x00000080);
    }

    @Override
    public boolean isYellowWaving() {
        return isFlagSet(0x00000100);
    }

    @Override
    public boolean isOneLapToGreen() {
        return isFlagSet(0x00000200);
    }

    @Override
    public boolean isGreenHeld() {
        return isFlagSet(0x00000400);
    }

    @Override
    public boolean isTenToGo() {
        return isFlagSet(0x00000800);
    }

    @Override
    public boolean isFiveToGo() {
        return isFlagSet(0x00001000);
    }

    @Override
    public boolean isRandomWaving() {
        return isFlagSet(0x00002000);
    }

    @Override
    public boolean isCaution() {
        return isFlagSet(0x00004000);
    }

    @Override
    public boolean isCautionWaving() {
        return isFlagSet(0x00008000);
    }

    @Override
    public boolean isBlack() {
        return isFlagSet(0x00010000);
    }

    @Override
    public boolean isDisqualify() {
        return isFlagSet(0x00020000);
    }

    @Override
    public boolean isServiceable() {
        return isFlagSet(0x00040000);
    }

    @Override
    public boolean isFurled() {
        return isFlagSet(0x00080000);
    }

    @Override
    public boolean isRepair() {
        return isFlagSet(0x00100000);
    }

    @Override
    public boolean isStartHidden() {
        return isFlagSet(0x00200000);
    }

    @Override
    public boolean isStartReady() {
        return isFlagSet(0x00400000);
    }

    @Override
    public boolean isStartSet() {
        return isFlagSet(0x00800000);
    }

}
