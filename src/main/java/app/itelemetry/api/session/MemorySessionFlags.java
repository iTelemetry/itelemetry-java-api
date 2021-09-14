package app.itelemetry.api.session;

public class MemorySessionFlags extends AbsSessionFlags {

    private final int value;

    public MemorySessionFlags() {
        this(LiveSessionFlags.getCurrentValue());
    }

    public MemorySessionFlags(int value) {
        this.value = value;
    }

    public MemorySessionFlags(SessionFlags flags) {
        this.value = flags.getValue();
    }

    @Override
    public int getValue() {
        return value;
    }

}
