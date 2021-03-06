package com.blackcat.cars.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.blackcat.cars.R;
import com.blackcat.cars.views.CarCreate.CarCreateActivity;
import com.blackcat.cars.views.CarsList.CarsListActivity;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import butterknife.BindView;
import dagger.android.support.DaggerAppCompatActivity;

public abstract class BaseDrawerActivity extends DaggerAppCompatActivity {

    @BindView(R.id.drawer_toolbar)
    Toolbar mToolbar;

    public BaseDrawerActivity(){

    }

    public void setupDrawer() {
        PrimaryDrawerItem listCarsItem = new PrimaryDrawerItem()
                .withIdentifier(CarsListActivity.IDENTIFIER)
                .withName("Cars");

        PrimaryDrawerItem createCarItem = new PrimaryDrawerItem()
                .withIdentifier(CarCreateActivity.IDENTIFIER)
                .withIcon(android.R.drawable.btn_plus)
                .withName("Create car");

        Drawer drawer = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(mToolbar)
                .addDrawerItems(
                        listCarsItem,
                        new DividerDrawerItem(),
                        createCarItem
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(
                            View view,
                            int position,
                            IDrawerItem drawerItem) {
                        long identifier = drawerItem.getIdentifier();

                        if (getIdentifier() == identifier) {
                            return false;
                        }

                        Intent intent = getNextIntent(identifier);
                        if (intent == null) {
                            return false;
                        }

                        startActivity(intent);
                        return true;
                    }
                })
                .build();
    }

    private Intent getNextIntent(long identifier) {
        if (identifier == CarCreateActivity.IDENTIFIER) {
            return new Intent(this, CarCreateActivity.class);
        }

        return null;
    }

    public Toolbar getToolbar() {
        return mToolbar;
    }

    protected abstract long getIdentifier();

    @Override
    protected void onStart() {
        super.onStart();
        setupDrawer();
    }

}
