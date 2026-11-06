package by.bsuir.device;

public class Laptop extends Device {
    private double screenSize;

    public Laptop(String model, int power, boolean isOn, double screenSize) {
        super(model, power, isOn);
        this.screenSize = screenSize;
    }

    public double getScreenSize() { return screenSize; }
    public void setScreenSize(double screenSize) { this.screenSize = screenSize; }

    @Override
    public void turnOn() {
        setOn(true);
        System.out.println("Ноутбук " + getModel() + " загружает ОС");
    }

    @Override
    public void turnOff() {
        setOn(false);
        System.out.println("Ноутбук " + getModel() + " завершает работу");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("  Экран: " + screenSize + "\"");
    }
}