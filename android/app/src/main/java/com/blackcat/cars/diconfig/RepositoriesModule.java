package com.blackcat.cars.diconfig;

import com.blackcat.cars.models.Car;
import com.blackcat.cars.repositories.InMemoryRepository;
import com.blackcat.cars.repositories.base.Repository;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoriesModule {
    @Provides
    @Singleton
    public Repository<Car> carRepository() {
        Repository<Car> repository = new InMemoryRepository<>();
        List<Car> initialCars = Arrays.asList(
                new Car("Mercedes", "S63"),
                new Car("Mercedes", "GTS"),
                new Car("BMW", "i8"),
                new Car("BMW", "M6"),
                new Car("BMW", "760"),
                new Car("VW", "Touareg"),
                new Car("VW", "Arteon"),
                new Car("VW", "Multivan"),
                new Car("Mercedes", "G"),
                new Car("Mercedes", "S"),
                new Car("Mercedes", "E"),
                new Car("Mercedes", "C")
        );

        initialCars.forEach(s -> {
            try {
                repository.add(s);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        return repository;
    }
}

