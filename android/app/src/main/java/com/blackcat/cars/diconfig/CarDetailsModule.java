package com.blackcat.cars.diconfig;

import com.blackcat.cars.views.CarDetails.CarDetailsContracts;
import com.blackcat.cars.views.CarDetails.CarDetailsFragment;
import com.blackcat.cars.views.CarDetails.CarDetailsPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class CarDetailsModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract CarDetailsFragment carDetailsFragment();

    @ActivityScoped
    @Binds
    abstract CarDetailsContracts.Presenter carsListPresenter(CarDetailsPresenter presenter);
}

