package lab10;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Smartphone s1 = new Smartphone("Samsung Galaxy S24", 45);
        Smartphone s2 = new Smartphone("iPhone 15", 0);
        Smartphone s3 = new Smartphone("Xiaomi 13", 80);

        Laptop l1 = new Laptop("Lenovo ThinkPad X1", 30, 14.0);
        Laptop l2 = new Laptop("Apple MacBook Pro", 75, 16.0);

        List<Switchable> switchables = new ArrayList<>();
        switchables.add(s1);
        switchables.add(s2);
        switchables.add(s3);
        switchables.add(l1);
        switchables.add(l2);

        List<Chargeable> chargeables = new ArrayList<>();
        chargeables.add(s1);
        chargeables.add(s2);
        chargeables.add(s3);
        chargeables.add(l1);
        chargeables.add(l2);

        System.out.println("Включение");
        for (Switchable dev : switchables) {
            dev.turnOn();
        }

        System.out.println("\nЗарядка");
        for (Chargeable dev : chargeables) {
            System.out.println("До зарядки: " + describe(dev));
            dev.charge();
            System.out.println("После зарядки: " + describe(dev));
        }

        System.out.println("\nПовторное включение разряженного смартфона");
        s2.turnOn();

        System.out.println("\nВыключение");
        for (Switchable dev : switchables) {
            dev.turnOff();
        }

        System.out.println("\nИтоговое состояние");
        switchables.forEach(d -> System.out.println(d));
    }

    private static String describe(Chargeable c) {
        return "заряд=" + c.getBatteryLevel() + "% (до полного: "
                + c.needCharge() + "%)";
    }
}