package com.gravityray.examples.mvvm.di.components.activities;

import com.gravityray.examples.mvvm.activities.MainActivity;
import com.gravityray.examples.mvvm.di.modules.activities.MainActivityContentModule;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by andrey_teteria on 12/11/17.
 */

@Subcomponent(modules = {
        MainActivityContentModule.class
})
public interface MainActivitySubcomponent extends AndroidInjector<MainActivity> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity> {
    }
}
