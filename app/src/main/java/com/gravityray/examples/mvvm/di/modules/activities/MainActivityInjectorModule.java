package com.gravityray.examples.mvvm.di.modules.activities;

import android.app.Activity;


import com.gravityray.examples.mvvm.activities.MainActivity;
import com.gravityray.examples.mvvm.di.components.activities.MainActivitySubcomponent;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

/**
 * Created by andrey_teteria on 12/11/17.
 */

@Module(subcomponents = MainActivitySubcomponent.class)
public abstract class MainActivityInjectorModule {
    @Binds
    @IntoMap
    @ActivityKey(MainActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> bindMainActivityInjectorFactory(
            MainActivitySubcomponent.Builder builder);

}
