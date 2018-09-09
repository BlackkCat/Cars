package com.blackcat.cars.views.CarsList;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.blackcat.cars.R;
import com.blackcat.cars.models.Car;
import com.blackcat.cars.views.BaseDrawerActivity;
import com.blackcat.cars.views.CarDetails.CarDetailsActivity;
import com.blackcat.cars.views.CarDetails.CarDetailsFragment;
import com.blackcat.cars.views.CarDetails.CarDetailsPresenter;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class CarsListActivity
        extends BaseDrawerActivity
        implements CarsListContracts.Navigator {
    public static final long IDENTIFIER = 49;

    @Inject
    CarsListFragment mCarsListFragment;

    @Inject
    CarsListContracts.Presenter mCarsListPresenter;

    @Inject
    CarDetailsFragment mCarDetailsFragment;

    @Inject
    CarDetailsPresenter mCarDetailsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cars_list);

        ButterKnife.bind(this);

        setSupportActionBar(getToolbar());

        mCarsListFragment.setNavigator(this);
        mCarsListFragment.setPresenter(mCarsListPresenter);

        FragmentTransaction transaction = getFragmentManager()
                .beginTransaction()
                .replace(R.id.content, mCarsListFragment);

        if (!isPhone()) {
            mCarDetailsFragment.setPresenter(mCarDetailsPresenter);
            transaction.replace(R.id.content_details, mCarDetailsFragment);
        }

        transaction.commit();
    }

    private boolean isPhone() {
        return findViewById(R.id.content_details) == null;
    }

    @Override
    protected long getIdentifier() {
        return IDENTIFIER;
    }

    @Override
    public void navigateWith(Car car) {
        if (isPhone()) {
            Intent intent = new Intent(
                    this,
                    CarDetailsActivity.class
            );

            intent.putExtra(CarDetailsActivity.EXTRA_KEY, car);

            startActivity(intent);
        } else {
            mCarDetailsPresenter.setCarId(car.getId());
            mCarDetailsPresenter.loadCar();
        }
    }
}

