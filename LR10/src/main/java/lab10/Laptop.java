package lab10;

public class Laptop implements Switchable, Chargeable {

    private String model;
    private int battery;
    private boolean on;
    private double screenSize;

    public Laptop(String model, int battery, double screenSize) {
        this.model = model;
        this.battery = clamp(battery);
        this.screenSize = screenSize;
    }

    private static int clamp(int v) {
        return Math.max(0, Math.min(MAX_BATTERY, v));
    }

    @Override
    public void turnOn() {
        if (battery == 0) {
            System.out.println(model + ": не включается — разряжен.");
            return;
        }
        on = true;
        System.out.println(model + ": включён.");
    }

    @Override
    public void turnOff() {
        on = false;
        System.out.println(model + ": выключен.");
    }

    @Override
    public boolean isOn() {
        return on;
    }

    @Override
    public void charge() {
        battery = MAX_BATTERY;
        System.out.println(model + ": заряжен до " + battery + "%.");
    }

    @Override
    public int getBatteryLevel() {
        return battery;
    }

    public double getScreenSize() {
        return screenSize;
    }

    @Override
    public String toString() {
        return "Laptop{" + model + ", battery=" + battery + "%, "
                + Switchable.status(on) + ", screen=" + screenSize + "}";
    }
}