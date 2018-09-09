package com.blackcat.cars.views.CarCreate;

import com.blackcat.cars.async.base.SchedulerProvider;
import com.blackcat.cars.models.Car;
import com.blackcat.cars.services.base.CarsService;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;

public class CarCreatePresenter implements  CarCreateContracts.Presenter{

    private final CarsService mCarsService;
    private final SchedulerProvider mSchedulerProvider;
    private CarCreateContracts.View mView;

    @Inject
    public CarCreatePresenter(
            CarsService carsService,
            SchedulerProvider schedulerProvider) {
        mCarsService = carsService;
        mSchedulerProvider = schedulerProvider;
    }

    @Override
    public void subscribe(CarCreateContracts.View view) {
        mView = view;
    }

    @Override
    public void unsubscribe() {
        mView = null;
    }

    @Override
    public void save(Car car) {
        mView.showLoading();
        Disposable disposable = Observable
                .create((ObservableOnSubscribe<Car>) emitter -> {
                    Car createdCar = mCarsService.createCar(car);
                    emitter.onNext(createdCar);
                    emitter.onComplete();
                })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .doOnEach(x -> mView.hideLoading())
                .doOnError(mView::showError)
                .subscribe(s -> mView.navigateToHome());
    }

}
