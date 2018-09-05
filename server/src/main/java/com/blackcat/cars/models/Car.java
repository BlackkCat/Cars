package com.blackcat.cars.models;

public class Car {
    private int id;
    private int numDoors;
    private String brand;
    private String model;

    public Car(int id, int numDoors, String brand, String model) {
        this.id = id;
        this.numDoors = numDoors;
        this.brand = brand;
        this.model = model;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumDoors() {
        return numDoors;
    }

    public void setNumDoors(int numDoors) {
        this.numDoors = numDoors;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
