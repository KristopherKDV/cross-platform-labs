package lab10;

public class Smartphone implements Switchable, Chargeable {

    private String model;
    private int battery;
    private boolean on;

    public Smartphone(String model, int battery) {
        this.model = model;
        this.battery = clamp(battery);
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

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return "Smartphone{" + model + ", battery=" + battery
                + "%, " + Switchable.status(on) + "}";
    }
}