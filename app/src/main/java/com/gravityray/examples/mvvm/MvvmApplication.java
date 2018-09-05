package com.gravityray.examples.mvvm;

import com.gravityray.examples.mvvm.di.components.ApplicationComponent;
import com.gravityray.examples.mvvm.di.components.DaggerApplicationComponent;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

public class MvvmApplication extends DaggerApplication {

    private ApplicationComponent applicationComponent;

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return applicationComponent;
    }

    @Override
    public void onCreate() {
        applicationComponent = DaggerApplicationComponent.builder()
                .application(this)
                .build();
        super.onCreate();
    }
}
