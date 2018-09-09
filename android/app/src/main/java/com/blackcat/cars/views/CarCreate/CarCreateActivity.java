package com.blackcat.cars.views.CarCreate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.blackcat.cars.R;
import com.blackcat.cars.views.BaseDrawerActivity;

public class CarCreateActivity extends BaseDrawerActivity implements  CarCreateContracts.Navigator {

    public static final long IDENTIFIER = 298;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_create);
    }

    @Override
    protected long getIdentifier() {
        return IDENTIFIER;
    }

    @Override
    public void navigateToHome() {

    }
}
