package com.example;

public class Building {
    private String address;
    private int floors;
    private double area;

    public Building(String address, int floors, double area) {
        this.address = address;
        this.floors = floors;
        this.area = area;
    }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public int getFloors() { return floors; }
    public void setFloors(int floors) { this.floors = floors; }

    public double getArea() { return area; }
    public void setArea(double area) { this.area = area; }

    public String getPurpose() {
        return "Здание общего назначения";
    }

    public void displayInfo() {
        System.out.printf("%s | адрес: %s | этажей: %d | площадь: %.1f м²%n",
                getPurpose(), address, floors, area);
    }
}