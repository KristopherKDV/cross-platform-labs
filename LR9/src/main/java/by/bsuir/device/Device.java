package by.bsuir.device;

public abstract class Device {
    private String model;
    private int power;
    private boolean isOn;

    public Device(String model, int power, boolean isOn) {
        this.model = model;
        this.power = power;
        this.isOn = isOn;
    }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public int getPower() { return power; }
    public void setPower(int power) { this.power = power; }

    public boolean isOn() { return isOn; }
    public void setOn(boolean on) { isOn = on; }

    public abstract void turnOn();
    public abstract void turnOff();

    public void displayInfo() {
        System.out.println("Модель: " + model +
                ", мощность: " + power + " Вт" +
                ", состояние: " + (isOn ? "включен" : "выключен"));
    }
}