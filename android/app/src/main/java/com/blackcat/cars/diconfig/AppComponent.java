package com.blackcat.cars.diconfig;

import android.app.Application;

import com.blackcat.cars.CarApplication;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        ActivityBindingModule.class,
        AppModule.class,
        ParsersModule.class,
        HttpModule.class,
        RepositoriesModule.class,
        ServicesModule.class,
        ValidatorsModule.class,
        AsyncModule.class,
        ViewsModule.class
})
public interface AppComponent extends AndroidInjector<CarApplication> {
    @Component.Builder
    interface Builder {

        @BindsInstance
        AppComponent.Builder application(Application application);

        AppComponent build();
    }
}

