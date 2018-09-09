package com.blackcat.cars.services;

import com.blackcat.cars.models.Car;

import java.util.List;

public interface CarService {
    void createCar(Car car);
    List<Car> getAllCars();
    Car getCarById(int id);
    void updateCar(int id, Car car);
    void deleteCar(int id);
}
