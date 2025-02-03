package enums;

public enum Nominals {
    RUB_5000(5000),
    RUB_1000(1000),
    RUB_500(500),
    RUB_100(100),
    RUB_50(50);

    private final int value;

    Nominals(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}