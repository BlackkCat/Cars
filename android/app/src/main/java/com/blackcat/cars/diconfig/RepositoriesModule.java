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
    public Repository<Car> superheroRepository() {
        Repository<Car> repository = new InMemoryRepository<>();
        List<Car> initialCars = Arrays.asList(
                new Car(3, "Mercedes", "S63"),
                new Car(3, "Mercedes", "GTS"),
                new Car(3, "BMW", "i8"),
                new Car(3, "BMW", "M6"),
                new Car(5, "BMW", "760"),
                new Car(5, "VW", "Touareg"),
                new Car(5, "VW", "Arteon"),
                new Car(5, "VW", "Multivan"),
                new Car(5, "Mercedes", "G"),
                new Car(5, "Mercedes", "S"),
                new Car(5, "Mercedes", "E"),
                new Car(5, "Mercedes", "C")
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

