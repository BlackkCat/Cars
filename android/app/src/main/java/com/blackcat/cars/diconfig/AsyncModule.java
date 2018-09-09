package com.blackcat.cars.diconfig;

import com.blackcat.cars.async.AsyncSchedulerProvider;
import com.blackcat.cars.async.base.SchedulerProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AsyncModule {
    @Provides
    @Singleton
    public SchedulerProvider schedulerProvider() {
        return AsyncSchedulerProvider.getInstance();
    }
}

