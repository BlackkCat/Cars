package com.blackcat.cars.views.CarDetails;

import com.blackcat.cars.models.Car;

public interface CarDetailsContracts {
    interface View {
        void showCar(Car car);

        void setPresenter(Presenter presenter);

        void showError(Throwable e);

        void showLoading();

        void hideLoading();
    }

    interface Presenter {
        void subscribe(View view);

        void loadCar();

        void setCarId(int id);
    }
}

