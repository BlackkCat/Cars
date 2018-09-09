package com.blackcat.cars;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class CarApplication extends DaggerApplication {
    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return null;
        //return DaggerAppComponent.builder().application(this).build();
    }
}

