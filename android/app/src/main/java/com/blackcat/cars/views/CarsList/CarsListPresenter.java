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

    private final CarsService mSuperheroesService;
    private final SchedulerProvider mSchedulerProvider;
    private CarsListContracts.View mView;

    @Inject
    public CarsListPresenter(
            CarsService superheroesService,
            SchedulerProvider schedulerProvider) {
        mSuperheroesService = superheroesService;
        mSchedulerProvider = schedulerProvider;
    }

    @Override
    // same as // setView(SuperheroesListContracts.View view)
    public void subscribe(CarsListContracts.View view) {
        mView = view;
    }

    @Override
    public void loadCars() {
        mView.showLoading();
        Disposable observable = Observable
                .create((ObservableOnSubscribe<List<Car>>) emitter -> {
                    List<Car> superheroes = mSuperheroesService.getAllCars();
                    emitter.onNext(superheroes);
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
                    List<Car> superheroes = mSuperheroesService.getFilteredCars(pattern);
                    emitter.onNext(superheroes);
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
    public void selectCar(Car superhero) {
        mView.showCarDetails(superhero);
    }

    private void presentCarsToView(List<Car> superheroes) {
        if (superheroes.isEmpty()) {
            mView.showEmptyCarsList();
        } else {
            mView.showCars(superheroes);
        }
    }
}

