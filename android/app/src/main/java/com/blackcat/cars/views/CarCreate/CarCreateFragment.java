package com.blackcat.cars.views.CarCreate;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blackcat.cars.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CarCreateFragment extends Fragment implements CarCreateContracts.View {


    public CarCreateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_car_create, container, false);
    }

    @Override
    public void setPresenter(CarCreateContracts.Presenter presenter) {
        
    }

    @Override
    public void navigateToHome() {

    }

    @Override
    public void showError(Throwable throwable) {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showLoading() {

    }
}
