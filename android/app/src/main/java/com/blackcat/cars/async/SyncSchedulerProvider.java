package com.blackcat.cars.async;

import com.blackcat.cars.async.base.SchedulerProvider;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

public class SyncSchedulerProvider implements SchedulerProvider {
    @Override
    public Scheduler background() {
        return Schedulers.trampoline();
    }

    @Override
    public Scheduler ui() {
        return Schedulers.trampoline();
    }
}
