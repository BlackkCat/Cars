package com.blackcat.cars.services;

import com.blackcat.cars.models.Car;
import com.blackcat.cars.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    private CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository){
        this.carRepository = carRepository;
    }

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
