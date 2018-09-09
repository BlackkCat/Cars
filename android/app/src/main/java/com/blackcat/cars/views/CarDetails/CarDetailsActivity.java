package com.blackcat.cars.views.CarDetails;

import android.content.Intent;
import android.os.Bundle;

import com.blackcat.cars.R;
import com.blackcat.cars.models.Car;
import com.blackcat.cars.views.BaseDrawerActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class CarDetailsActivity extends BaseDrawerActivity {
    public static final String EXTRA_KEY = "CAR_EXTRA_KEY";

    @Inject
    CarDetailsFragment mCarDetailsFragment;

    @Inject
    CarDetailsContracts.Presenter mCarDetailsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_details);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        Car car = (Car) intent.getSerializableExtra(CarDetailsActivity.EXTRA_KEY);

        mCarDetailsPresenter.setCarId(car.getId());
        mCarDetailsFragment.setPresenter(mCarDetailsPresenter);

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.content, mCarDetailsFragment)
                .commit();
    }

    @Override
    protected long getIdentifier() {
        return 0;
    }
}

