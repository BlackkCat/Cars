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
        setCarRepository(carRepository);
    }

    @Override
    public void createCar(Car car) {
        carRepository.createCar(car);
    }

    @Override
    public List<Car> getAllCars() {
        return carRepository.getAllCars();
    }

    @Override
    public Car getCarById(int id) {
        return carRepository.getCarById(id);
    }

    @Override
    public void updateCar(int id, Car car) {
        carRepository.updateCar(id, car);
    }

    @Override
    public void deleteCar(int id) {
        carRepository.deleteCar(id);
    }

    public CarRepository getCarRepository() {
        return carRepository;
    }

    public void setCarRepository(CarRepository carRepository) {
        this.carRepository = carRepository;
    }
}
