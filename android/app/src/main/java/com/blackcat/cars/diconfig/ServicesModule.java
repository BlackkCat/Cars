package com.blackcat.cars.diconfig;

import com.blackcat.cars.models.Car;
import com.blackcat.cars.repositories.base.Repository;
import com.blackcat.cars.services.HttpCarsService;
import com.blackcat.cars.services.base.CarsService;
import com.blackcat.cars.validators.base.Validator;

import dagger.Module;
import dagger.Provides;

@Module
public class ServicesModule {
    @Provides
    public CarsService superheroesService(Repository<Car> repository, Validator<Car> validator) {
        return new HttpCarsService(repository, validator);
    }
}

