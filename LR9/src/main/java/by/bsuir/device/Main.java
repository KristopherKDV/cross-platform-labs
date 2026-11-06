package by.bsuir.device;

public class Main {
    public static void main(String[] args) {
        Device[] devices = new Device[] {
                new Smartphone("Samsung Galaxy S24", 25, false, 50),
                new Smartphone("iPhone 15", 20, false, 48),
                new Smartphone("Xiaomi Redmi Note 13", 18, false, 108),
                new Laptop("Lenovo IdeaPad 5", 65, true, 15.6),
                new Laptop("ASUS Vivobook 16", 90, false, 16.0)
        };

        System.out.println("=== Информация об устройствах ===");
        for (Device d : devices) {
            d.displayInfo();
            System.out.println();
        }

        System.out.println("=== Включение и выключение ===");
        for (Device d : devices) {
            d.turnOn();
            d.turnOff();
            System.out.println();
        }
    }
}