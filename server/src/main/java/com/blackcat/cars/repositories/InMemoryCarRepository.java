package com.blackcat.cars.repositories;

import com.blackcat.cars.models.Car;

import java.util.List;

public class InMemoryCarRepository implements CarRepository {
    @Override
    public void createCar(Car car) {

    }

    @Override
    public List<Car> getAllCars() {
        return null;
    }

    @Override
    public Car getCarById(int id) {
        return null;
    }

    @Override
    public void updateCar(int id, Car car) {

    }

    @Override
    public void deleteCar(int id) {

    }
}
