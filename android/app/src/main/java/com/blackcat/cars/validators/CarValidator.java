package com.blackcat.cars.validators;

import android.provider.SyncStateContract;

import com.blackcat.cars.Constants;
import com.blackcat.cars.models.Car;
import com.blackcat.cars.validators.base.Validator;

public class CarValidator implements Validator<Car> {
    @Override
    public boolean isValid(Car object) {
        return object != null &&
                isBrandValid(object) &&
                isModelValid(object);
    }

    private boolean isBrandValid(Car object) {
        return object.getBrand().length() >= Constants.CAR_BRAND_MIN_LENGHT &&
                object.getBrand().length() <= Constants.CAR_BRAND_MAX_LENGHT;
    }

    private boolean isModelValid(Car object) {
        return object.getModel().length() >= Constants.CAR_MODEL_MIN_LENGHT &&
                object.getModel().length() <= Constants.CAR_MODEL_MAX_LENGHT;
    }
}
