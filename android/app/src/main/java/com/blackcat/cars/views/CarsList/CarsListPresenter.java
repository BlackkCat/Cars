package com.blackcat.cars.views.CarsList;

import com.blackcat.cars.async.base.SchedulerProvider;
import com.blackcat.cars.models.Car;
import com.blackcat.cars.services.base.CarsService;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;

public class CarsListPresenter
        implements CarsListContracts.Presenter {

    private final CarsService mCarsService;
    private final SchedulerProvider mSchedulerProvider;
    private CarsListContracts.View mView;

    @Inject
    public CarsListPresenter(
            CarsService carsService,
            SchedulerProvider schedulerProvider) {
        mCarsService = carsService;
        mSchedulerProvider = schedulerProvider;
    }

    @Override
    // same as // setView(CarsListContracts.View view)
    public void subscribe(CarsListContracts.View view) {
        mView = view;
    }

    @Override
    public void loadCars() {
        mView.showLoading();
        Disposable observable = Observable
                .create((ObservableOnSubscribe<List<Car>>) emitter -> {
                    List<Car> cars = mCarsService.getAllCars();
                    emitter.onNext(cars);
                    emitter.onComplete();
                })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .doFinally(mView::hideLoading)
                .subscribe(
                        this::presentCarsToView,
                        error -> mView.showError(error)
                );
    }

    @Override
    public void filterCars(String pattern) {
        mView.showLoading();
        Disposable observable = Observable
                .create((ObservableOnSubscribe<List<Car>>) emitter -> {
                    List<Car> cars = mCarsService.getFilteredCars(pattern);
                    emitter.onNext(cars);
                    emitter.onComplete();
                })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .doFinally(mView::hideLoading)
                .subscribe(
                        this::presentCarsToView,
                        error -> mView.showError(error)
                );
    }

    @Override
    public void selectCar(Car car) {
        mView.showCarDetails(car);
    }

    private void presentCarsToView(List<Car> cars) {
        if (cars.isEmpty()) {
            mView.showEmptyCarsList();
        } else {
            mView.showCars(cars);
        }
    }
}

