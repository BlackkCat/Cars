package com.blackcat.cars.diconfig;

import com.blackcat.cars.views.CarCreate.CarCreateActivity;
import com.blackcat.cars.views.CarDetails.CarDetailsActivity;
import com.blackcat.cars.views.CarsList.CarsListActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {
    @ActivityScoped
    @ContributesAndroidInjector(
            modules = CarsListModule.class
    )
    abstract CarsListActivity carsListActivity();

    @ActivityScoped
    @ContributesAndroidInjector(
            modules = CarDetailsModule.class
    )
    abstract CarDetailsActivity carDetailsActivity();

    @ActivityScoped
    @ContributesAndroidInjector(
            modules = CarCreateModule.class
    )
    abstract CarCreateActivity carCreateActivity();
}

