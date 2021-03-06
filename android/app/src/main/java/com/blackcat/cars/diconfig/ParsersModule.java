package com.blackcat.cars.diconfig;

import com.blackcat.cars.models.Car;
import com.blackcat.cars.parsers.GsonJsonParser;
import com.blackcat.cars.parsers.base.JsonParser;

import dagger.Module;
import dagger.Provides;

@Module
public class ParsersModule {
    @Provides
    public JsonParser<Car> carJsonParser() {
        return new GsonJsonParser<>(Car.class, Car[].class);
    }
}

