package com.blackcat.cars.diconfig;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.blackcat.cars.views.CarsList.CarsAdapter;

import dagger.Module;
import dagger.Provides;

@Module
public class ViewsModule {
    @Provides
    public RecyclerView.Adapter<CarsAdapter.CarViewHolder> carArrayAdapter(Context context) {
        return new CarsAdapter();
    }
}

