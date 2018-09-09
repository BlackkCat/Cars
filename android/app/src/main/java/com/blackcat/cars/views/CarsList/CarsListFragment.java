package com.blackcat.cars.views.CarsList;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.blackcat.cars.R;
import com.blackcat.cars.models.Car;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnTextChanged;

/**
 * A simple {@link Fragment} subclass.
 */
public class CarsListFragment
        extends Fragment
        implements CarsListContracts.View, CarsAdapter.OnCarClickListener {
    private CarsListContracts.Navigator mNavigator;

    @BindView(R.id.lv_cars)
    RecyclerView mCarsView;

    @BindView(R.id.loading)
    ProgressBar mLoadingView;

    @BindView(R.id.et_filter)
    EditText mFilterEditText;

    @Inject
    CarsAdapter mCarsAdapter;

    private CarsListContracts.Presenter mPresenter;
    private GridLayoutManager mCarsViewLayoutManager;

    @Inject
    public CarsListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cars_list, container, false);

        // ButterKnife is applied
        ButterKnife.bind(this, view);

        mCarsAdapter.setOnCarClickListener(this);

        mCarsView.setAdapter(mCarsAdapter);
        mCarsViewLayoutManager = new GridLayoutManager(getContext(), 2);
        mCarsView.setLayoutManager(mCarsViewLayoutManager);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe(this);
        mPresenter.loadCars();
    }

    @Override
    public void setPresenter(CarsListContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showCars(List<Car> cars) {
        mCarsAdapter.clear();
        mCarsAdapter.addAll(cars);
        mCarsAdapter.notifyDataSetChanged();
    }

    @Override
    public void showEmptyCarsList() {
        Toast.makeText(getContext(),
                "No superheroes",
                Toast.LENGTH_LONG)
                .show();
    }

    @Override
    public void showError(Throwable e) {
        Toast.makeText(getContext(), "Error: " + e.getMessage(), Toast.LENGTH_LONG)
                .show();
    }

    @Override
    public void showLoading() {
        mCarsView.setVisibility(View.GONE);
        mLoadingView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mCarsView.setVisibility(View.VISIBLE);
        mLoadingView.setVisibility(View.GONE);
    }

    @Override
    public void showSuperheroDetails(Car car) {
        mNavigator.navigateWith(car);
    }

    void setNavigator(CarsListContracts.Navigator navigator) {
        mNavigator = navigator;
    }

    @OnTextChanged(R.id.et_filter)
    public void onTextChanged() {
        String pattern = mFilterEditText.getText().toString();
        mPresenter.filterCars(pattern);
    }

    @Override
    public void onClick(Car car) {
        mPresenter.selectCar(car);
    }
}

