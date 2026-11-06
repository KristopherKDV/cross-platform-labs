package com.example;

public class Residential extends Building {
    private int apartments;

    public Residential(String address, int floors, double area, int apartments) {
        super(address, floors, area);
        this.apartments = apartments;
    }

    public int getApartments() { return apartments; }
    public void setApartments(int apartments) { this.apartments = apartments; }

    @Override
    public String getPurpose() {
        return "Жилой дом";
    }

    public double getApartmentPrice() {
        return (getArea() / apartments) * 1000;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.printf("  → квартир: %d, средняя цена квартиры: %.2f%n",
                apartments, getApartmentPrice());
    }
}