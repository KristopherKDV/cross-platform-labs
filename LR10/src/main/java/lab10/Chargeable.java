package lab10;

public interface Chargeable {

    int MAX_BATTERY = 100;

    void charge();

    int getBatteryLevel();

    default int needCharge() {
        return MAX_BATTERY - getBatteryLevel();
    }
}