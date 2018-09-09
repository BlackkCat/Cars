package com.blackcat.cars.models;


import java.io.Serializable;

public class Car implements Serializable {
    public int id;
    public String brand;
    public String model;

    public Car(){

    }

    public Car(String brand, String model) {
        setBrand(brand);
        setModel(model);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

