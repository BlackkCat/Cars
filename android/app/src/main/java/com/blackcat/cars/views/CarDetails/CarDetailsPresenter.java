package com.blackcat.cars.views.CarDetails;

import com.blackcat.cars.async.base.SchedulerProvider;
import com.blackcat.cars.models.Car;
import com.blackcat.cars.services.base.CarsService;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;

public class CarDetailsPresenter
        implements CarDetailsContracts.Presenter {
    private final CarsService mSuperheroesService;
    private final SchedulerProvider mSchedulerProvider;

    private CarDetailsContracts.View mView;
    private int mCarId;

    @Inject
    public CarDetailsPresenter(
            CarsService superheroesService,
            SchedulerProvider schedulerProvider
    ) {
        mSuperheroesService = superheroesService;
        mSchedulerProvider = schedulerProvider;
    }

    @Override
    public void subscribe(CarDetailsContracts.View view) {
        mView = view;
    }

    @Override
    public void loadCar() {
        mView.showLoading();
        Disposable observable = Observable
                .create((ObservableOnSubscribe<Car>) emitter -> {
                    Car car = mSuperheroesService.getDetailsById(mCarId);
                    emitter.onNext(car);
                    emitter.onComplete();
                })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .doOnError(mView::showError)
                .subscribe(mView::showCar);
    }

    @Override
    public void setCarId(int carId) {
        mCarId = carId;
    }
}

