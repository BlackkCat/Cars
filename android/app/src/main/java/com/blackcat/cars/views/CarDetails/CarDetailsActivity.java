package com.blackcat.cars.views.CarDetails;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.blackcat.cars.R;
import com.blackcat.cars.models.Car;
import com.blackcat.cars.views.BaseDrawerActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class CarDetailsActivity extends BaseDrawerActivity {
    public static final String EXTRA_KEY = "CAR_EXTRA_KEY";

    @Inject
    CarDetailsFragment mSuperheroDetailsFragment;

    @Inject
    CarDetailsContracts.Presenter mSuperheroDetailsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_superhero_details);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        Car car = (Car) intent.getSerializableExtra(CarDetailsActivity.EXTRA_KEY);

        mSuperheroDetailsPresenter.setCarId(car.getId());
        mSuperheroDetailsFragment.setPresenter(mSuperheroDetailsPresenter);

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.content, mSuperheroDetailsFragment)
                .commit();
    }

    @Override
    protected long getIdentifier() {
        return 0;
    }
}

