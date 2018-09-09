package com.blackcat.cars.diconfig;

import com.blackcat.cars.views.CarCreate.CarCreateContracts;
import com.blackcat.cars.views.CarCreate.CarCreateFragment;
import com.blackcat.cars.views.CarCreate.CarCreatePresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class CarCreateModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract CarCreateFragment carCreateFragment();

    @ActivityScoped
    @Binds
    abstract CarCreateContracts.Presenter carCreatePresenter(CarCreatePresenter presenter);
}

