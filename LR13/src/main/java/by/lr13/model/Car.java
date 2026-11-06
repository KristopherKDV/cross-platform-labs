package by.lr13.model;

import by.lr13.exception.InvalidCarDataException;

import java.util.Objects;

public class Car {
    private String brand;
    private String model;
    private int year;
    private int mileage;
    private double price;

    public Car(String brand, String model, int year, int mileage, double price)
            throws InvalidCarDataException {
        setBrand(brand);
        setModel(model);
        setYear(year);
        setMileage(mileage);
        setPrice(price);
    }

    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public int getYear() { return year; }
    public int getMileage() { return mileage; }
    public double getPrice() { return price; }

    public String getKey() {
        return brand + " " + model;
    }

    public void setBrand(String brand) throws InvalidCarDataException {
        if (brand == null || brand.isBlank()) {
            throw new InvalidCarDataException("Марка не может быть пустой");
        }
        this.brand = brand;
    }

    public void setModel(String model) throws InvalidCarDataException {
        if (model == null || model.isBlank()) {
            throw new InvalidCarDataException("Модель не может быть пустой");
        }
        this.model = model;
    }

    public void setYear(int year) throws InvalidCarDataException {
        if (year < 1900 || year > 2025) {
            throw new InvalidCarDataException("Год должен быть в диапазоне 1900-2025");
        }
        this.year = year;
    }

    public void setMileage(int mileage) throws InvalidCarDataException {
        if (mileage < 0) {
            throw new InvalidCarDataException("Пробег не может быть отрицательным");
        }
        this.mileage = mileage;
    }

    public void setPrice(double price) throws InvalidCarDataException {
        if (price <= 0) {
            throw new InvalidCarDataException("Цена должна быть больше нуля");
        }
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return year == car.year
                && mileage == car.mileage
                && Double.compare(price, car.price) == 0
                && Objects.equals(brand, car.brand)
                && Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, year, mileage, price);
    }

    @Override
    public String toString() {
        return String.format("Car{brand='%s', model='%s', year=%d, mileage=%d, price=%.2f}",
                brand, model, year, mileage, price);
    }
}