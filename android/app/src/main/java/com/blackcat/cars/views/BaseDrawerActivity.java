package com.blackcat.cars.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.blackcat.cars.R;

import dagger.android.support.DaggerAppCompatActivity;

public abstract class BaseDrawerActivity extends DaggerAppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_drawer);
    }
}
