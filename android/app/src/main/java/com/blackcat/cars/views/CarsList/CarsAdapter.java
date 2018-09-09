package com.blackcat.cars.views.CarsList;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.blackcat.cars.models.Car;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CarsAdapter extends RecyclerView.Adapter<CarsAdapter.CarViewHolder> {
    private List<Car> mCars;
    private OnCarClickListener mOnCarClickListener;

    @Inject
    public CarsAdapter() {
        mCars = new ArrayList<>();
    }

    @NonNull
    @Override
    public CarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.car_item, parent, false);
        int height = parent.getMeasuredHeight() / 3;
        ViewGroup.LayoutParams lp = view.getLayoutParams();
        lp.height = height;
        view.setLayoutParams(lp);
        view.setMinimumHeight(height);
        return new CarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarViewHolder holder, int position) {
        holder.setOnClickListener(mOnCarClickListener);
        holder.bind(mCars.get(position));
    }

    @Override
    public int getItemCount() {
        return mCars.size();
    }

    public Car getItem(int position) {
        return mCars.get(position);
    }

    public void clear() {
        mCars.clear();
    }

    public void addAll(List<Car> cars) {
        mCars.addAll(cars);
    }

    public void setOnCarClickListener(OnCarClickListener onCarClickListener) {
        this.mOnCarClickListener = onCarClickListener;
    }

    public static class CarViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.et_numDoors)
        EditText mNumDoors;

        @BindView(R.id.et_brand)
        EditText mBrand;

        @BindView(R.id.et_model)
        EditText mModel;

        private OnCarClickListener mOnClickListener;
        private Car mCar;

        CarViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        void bind(Car car) {
            mNumDoors.setText(car.getNumDoors());
            mBrand.setText(car.getBrand());
            mModel.setText(car.getModel());
//            Picasso.get()
//                    .load(superhero.getImageUrl())
//                    .into(mSuperheroImageView);
            mCar = car;
        }

        @OnClick
        public void onClick() {
            mOnClickListener.onClick(mCar);
        }

        public void setOnClickListener(OnCarClickListener onClickListener) {
            mOnClickListener = onClickListener;
        }
    }

    interface OnCarClickListener {
        void onClick(Car car);
    }
}

