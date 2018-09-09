package com.blackcat.cars.models;


import java.io.Serializable;

public class Car implements Serializable {
    public String imageUrl;
    public int id;
    public String name;
    public String secretIdentity;

    public Car() {
        // public constructor is needed for parsing from/to JSON to work
    }

    public Car(String name, String secretIdentity, String imageUrl) {
        this.name = name;
        this.secretIdentity = secretIdentity;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public String getSecretIdentity() {
        return secretIdentity;
    }

    public int getId() {
        return id;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}

