package com.blackcat.cars.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class BaseDrawerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_drawer);
    }
}