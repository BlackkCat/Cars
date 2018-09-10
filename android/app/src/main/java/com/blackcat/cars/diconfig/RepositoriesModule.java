package com.blackcat.cars.diconfig;

import com.blackcat.cars.http.HttpRequester;
import com.blackcat.cars.models.Car;
import com.blackcat.cars.parsers.base.JsonParser;
import com.blackcat.cars.repositories.HttpRepository;
import com.blackcat.cars.repositories.base.Repository;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoriesModule {
    @Provides
    @Singleton
    public Repository<Car> carRepository(
            @Named("baseServerUrl") String baseServerUrl,
            HttpRequester httpRequester,
            JsonParser<Car> jsonParser) {
        String url = baseServerUrl + "/cars";
        return new HttpRepository<>(url, httpRequester, jsonParser);
    }
}

