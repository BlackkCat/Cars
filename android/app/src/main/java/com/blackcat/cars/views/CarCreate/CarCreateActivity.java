package com.blackcat.cars.views.CarCreate;

import android.content.Intent;
import android.os.Bundle;

import com.blackcat.cars.R;
import com.blackcat.cars.views.BaseDrawerActivity;
import com.blackcat.cars.views.CarsList.CarsListActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class CarCreateActivity extends BaseDrawerActivity implements CarCreateContracts.Navigator {

    public static final long IDENTIFIER = 298;

    @Inject
    CarCreateFragment mView;

    @Inject
    CarCreateContracts.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_create);
        ButterKnife.bind(this);

        mView.setPresenter(mPresenter);
        mView.setNavigator(this);

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.content, mView)
                .commit();

    }

    @Override
    protected long getIdentifier() {
        return IDENTIFIER;
    }

    @Override
    public void navigateToHome() {
        Intent intent = new Intent(this, CarsListActivity.class);
        startActivity(intent);
        finish();
    }
}
