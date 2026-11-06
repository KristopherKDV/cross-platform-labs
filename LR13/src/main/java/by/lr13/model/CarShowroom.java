package by.lr13.model;

import by.lr13.exception.CarNotFoundException;
import by.lr13.exception.InvalidCarDataException;
import by.lr13.exception.PriceUpdateException;

import java.util.ArrayList;
import java.util.List;

public class CarShowroom {
    private final List<Car> cars = new ArrayList<>();

    public void addCar(Car car) {
        cars.add(car);
    }

    public Car findCar(String key) throws CarNotFoundException {
        for (Car car : cars) {
            if (car.getKey().equals(key)) {
                return car;
            }
        }
        throw new CarNotFoundException("Автомобиль с ключом '" + key + "' не найден");
    }

    public void updatePrice(String key, double newPrice)
            throws CarNotFoundException, PriceUpdateException, InvalidCarDataException {

        Car car = findCar(key);

        if (newPrice > car.getPrice() * 2) {
            throw new PriceUpdateException("Новая цена не может превышать текущую более чем в 2 раза");
        }

        car.setPrice(newPrice);
    }

    public void addMileage(String key, int km)
            throws CarNotFoundException, InvalidCarDataException {
        Car car = findCar(key);
        car.setMileage(car.getMileage() + km);
    }

    public void printAll() {
        for (Car car : cars) {
            System.out.println(car);
        }
    }
}