package com.blackcat.cars.services;

import com.blackcat.cars.models.Car;
import com.blackcat.cars.repositories.base.Repository;
import com.blackcat.cars.services.base.CarsService;
import com.blackcat.cars.validators.base.Validator;

import java.util.List;
import java.util.stream.Collectors;

public class HttpCarsService implements CarsService {
    private final Repository<Car> mCarsRepository;
    private final Validator<Car> mCarValidator;

    public HttpCarsService(
            Repository<Car> carsRepository,
            Validator<Car> carValidator) {
        mCarsRepository = carsRepository;
        mCarValidator = carValidator;
    }

    @Override
    public List<Car> getAllCars() throws Exception {
        return mCarsRepository.getAll();
    }

    @Override
    public Car getDetailsById(int id) throws Exception {
        return mCarsRepository.getById(id);
    }

    @Override
    public List<Car> getFilteredCars(String pattern) throws Exception {
        String patternToLower = pattern.toLowerCase();

        return getAllCars().stream()
                .filter(car -> car.getBrand().toLowerCase().contains(patternToLower))
                .collect(Collectors.toList());
    }

    @Override
    public Car createCar(Car car) throws Exception {
        if (!mCarValidator.isValid(car)) {
            throw new IllegalArgumentException("Car is invalid");
        }

        return mCarsRepository.add(car);
    }
}

