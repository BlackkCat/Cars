package com.blackcat.cars.models;

import javax.annotation.Generated;

public class Car {
    private int id;
    private String brand;
    private String model;

    public Car(){
        
    }

    public Car(int id, String brand, String model) {
        setId(id);
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
