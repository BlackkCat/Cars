package com.blackcat.cars.views.CarCreate;

import com.blackcat.cars.models.Car;

public interface CarCreateContracts {
    interface View {

        void setPresenter(Presenter presenter);

        void navigateToHome();

        void showError(Throwable throwable);

        void hideLoading();

        void showLoading();
    }

    interface Presenter {

        void subscribe(View view);

        void unsubscribe();

        void save(Car car);
    }

    public interface Navigator {

        void navigateToHome();
    }

}
