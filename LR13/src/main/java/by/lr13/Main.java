package by.lr13;

import by.lr13.exception.CarNotFoundException;
import by.lr13.exception.InvalidCarDataException;
import by.lr13.exception.PriceUpdateException;
import by.lr13.model.Car;
import by.lr13.model.CarShowroom;

public class Main {
    public static void main(String[] args) {
        CarShowroom showroom = new CarShowroom();

        try {
            showroom.addCar(new Car("Lada", "Vesta", 2022, 15000, 12000.0));
            showroom.addCar(new Car("Audi", "A4", 2019, 80000, 25000.0));
            showroom.addCar(new Car("Toyota", "Camry", 2020, 45000, 22000.0));
        } catch (InvalidCarDataException e) {
            System.err.println("Ошибка при создании автомобиля: " + e.getMessage());
        }

        System.out.println("--- Все автомобили в салоне ---");
        showroom.printAll();
        System.out.println();

        try {
            showroom.updatePrice("Lada Vesta", 11500.0);
            System.out.println("Цена Lada Vesta успешно обновлена.");
        } catch (CarNotFoundException | PriceUpdateException | InvalidCarDataException e) {
            System.out.println("Ошибка обновления цены: " + e.getMessage());
        }

        try {
            showroom.updatePrice("Ford Focus", 10000.0);
        } catch (CarNotFoundException e) {
            System.out.println("Автомобиль не найден: " + e.getMessage());
        } catch (PriceUpdateException | InvalidCarDataException e) {
            System.out.println("Ошибка обновления цены: " + e.getMessage());
        }

        try {
            showroom.updatePrice("Audi A4", 60000.0);
        } catch (PriceUpdateException e) {
            System.out.println("Ошибка обновления цены: " + e.getMessage());
        } catch (CarNotFoundException | InvalidCarDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            showroom.updatePrice("Audi A4", -1000.0);
        } catch (InvalidCarDataException e) {
            System.out.println("Некорректные данные: " + e.getMessage());
        } catch (CarNotFoundException | PriceUpdateException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            showroom.addMileage("Toyota Camry", 5000);
            System.out.println("Пробег Toyota Camry успешно обновлен.");
        } catch (CarNotFoundException | InvalidCarDataException e) {
            System.out.println("Ошибка добавления пробега: " + e.getMessage());
        }

        try {
            showroom.addMileage("Toyota Camry", -100);
        } catch (InvalidCarDataException e) {
            System.out.println("Некорректные данные: " + e.getMessage());
        } catch (CarNotFoundException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        System.out.println("\n--- Итоговое состояние автосалона ---");
        showroom.printAll();
    }
}