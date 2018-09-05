package com.blackcat.cars.repositories;

import com.blackcat.cars.models.Car;

import java.util.ArrayList;
import java.util.List;

public class InMemoryCarRepository implements CarRepository {
    private List<Car> cars = new ArrayList<>();

    public InMemoryCarRepository() {
    }

    @Override
    public void createCar(Car car) {
        cars.add(car);
    }

    @Override
    public List<Car> getAllCars() {
        return cars;
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
