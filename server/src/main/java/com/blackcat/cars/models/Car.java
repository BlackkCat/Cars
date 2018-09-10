package com.blackcat.cars.models;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Car {
    private int id;
    @NotNull
    @Size(min = 2, max = 10)
    private String brand;
    @NotNull
    @Size(min = 2, max = 20)
    private String model;

    public Car(){

    }

    public Car(int id, String brand, String model) {
        setId(1 + (int)(Math.random() * 100));
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
