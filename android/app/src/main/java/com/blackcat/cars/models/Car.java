package com.blackcat.cars.models;


import java.io.Serializable;

public class Car implements Serializable {
    public int id;
    public int numDoors;
    public String brand;
    public String model;

    public Car(){

    }

    public Car(int numDoors, String brand, String model) {
        setNumDoors(numDoors);
        setBrand(brand);
        setModel(model);
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

