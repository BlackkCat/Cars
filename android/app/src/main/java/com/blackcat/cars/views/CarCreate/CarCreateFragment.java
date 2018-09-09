package com.blackcat.cars.views.CarCreate;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.blackcat.cars.R;
import com.blackcat.cars.models.Car;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class CarCreateFragment extends Fragment implements CarCreateContracts.View {
    private CarCreateContracts.Presenter mPresenter;
//String brand, String model
    @BindView(R.id.et_brand)
    EditText mBrand;

    @BindView(R.id.et_model)
    EditText mModel;

    private CarCreateContracts.Navigator mNavigator;


    @Inject
    public CarCreateFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_car_create, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        mPresenter.unsubscribe();
    }

    @OnClick(R.id.btn_save)
    public void onCarSaveClicked() {
        String brand = mBrand.getText().toString();
        String model = mModel.getText().toString();
        Car car = new Car(brand, model);
        mPresenter.save(car);
    }


    @Override
    public void setPresenter(CarCreateContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void navigateToHome() {
        mNavigator.navigateToHome();
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

    public void setNavigator(CarCreateContracts.Navigator navigator) {
        mNavigator = navigator;
    }

}
