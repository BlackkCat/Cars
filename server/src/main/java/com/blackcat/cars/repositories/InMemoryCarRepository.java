package com.blackcat.cars.repositories;

import com.blackcat.cars.models.Car;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryCarRepository implements CarRepository {
    private List<Car> cars = new ArrayList<>();

    public InMemoryCarRepository() {
        cars.add(new Car(11,"aaaa", "bbbbbb"));
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
        return getCar(id);
    }

    @Override
    public void updateCar(int id, Car car) {
        Car c = getCar(id);
        int index = cars.indexOf(c);
        cars.set(index, car);
    }

    @Override
    public void deleteCar(int id) {
        Car c = getCar(id);
        cars.remove(c);
    }

    private Car getCar(int id){
        return cars.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
