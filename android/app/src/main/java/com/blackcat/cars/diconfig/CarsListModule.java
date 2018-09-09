package com.blackcat.cars.diconfig;

import com.blackcat.cars.views.CarsList.CarsListContracts;
import com.blackcat.cars.views.CarsList.CarsListFragment;
import com.blackcat.cars.views.CarsList.CarsListPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class CarsListModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract CarsListFragment superheroesListFragment();

    @ActivityScoped
    @Binds
    abstract CarsListContracts.Presenter superheroesListPresenter(CarsListPresenter presenter);
}

