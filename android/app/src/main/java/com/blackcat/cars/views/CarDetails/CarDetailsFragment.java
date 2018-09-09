package com.blackcat.cars.views.CarDetails;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.blackcat.cars.R;
import com.blackcat.cars.models.Car;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class CarDetailsFragment
        extends Fragment
        implements CarDetailsContracts.View {

    private CarDetailsContracts.Presenter mPresenter;

    @BindView(R.id.tv_brand)
    TextView mBrand;

    @BindView(R.id.tv_model)
    TextView mModel;

    @Inject
    public CarDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_car_details, container, false);

        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe(this);
        mPresenter.loadCar();
    }

    @Override
    public void showCar(Car car) {
        mBrand.setText(car.getBrand());
        mModel.setText(car.getModel());
    }

    @Override
    public void setPresenter(CarDetailsContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showError(Throwable e) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}

