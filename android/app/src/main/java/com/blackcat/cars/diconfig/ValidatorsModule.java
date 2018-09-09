package com.blackcat.cars.diconfig;

import com.blackcat.cars.models.Car;
import com.blackcat.cars.validators.CarValidator;
import com.blackcat.cars.validators.base.Validator;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ValidatorsModule {
    @Provides
    @Singleton
    public Validator<Car> superheroValidator() {
        return new CarValidator();
    }
}

