package com.blackcat.cars.services.base;

import com.blackcat.cars.models.Car;

import java.util.List;

public interface CarsService {
    List<Car> getAllCars() throws Exception;

    Car getDetailsById(int id) throws Exception;

    List<Car> getFilteredCars(String pattern) throws Exception;

    Car createCar(Car car) throws Exception;
}

