package lab10;

public interface Switchable {

    void turnOn();

    void turnOff();

    boolean isOn();

    static String status(boolean on) {
        return on ? "включено" : "выключено";
    }
}