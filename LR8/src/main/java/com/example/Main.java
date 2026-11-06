package com.example;

public class Main {
    public static void main(String[] args) {
        Building[] buildings = new Building[5];

        buildings[0] = new Residential("ул. Ленина, 10", 5, 3200.0, 60);
        buildings[1] = new Residential("пр. Мира, 25", 9, 8100.0, 120);
        buildings[2] = new Residential("ул. Гагарина, 7", 3, 1500.0, 24);

        buildings[3] = new Office("ул. Пушкина, 15", 12, 9500.0, 40);
        buildings[4] = new Office("пр. Независимости, 3", 7, 4200.0, 18);

        System.out.println("Все здания");
        for (Building b : buildings) {
            b.displayInfo();
        }

        System.out.println("\nУникальные методы");
        for (Building b : buildings) {
            if (b instanceof Residential r) {
                System.out.printf("Residential: средняя цена квартиры = %.2f%n",
                        r.getApartmentPrice());
            } else if (b instanceof Office o) {
                System.out.printf("Office: аренда = %.2f%n", o.getRentPrice());
            }
        }
    }
}