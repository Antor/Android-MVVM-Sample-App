package com.gravityray.examples.mvvm.di.modules.activities;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;


import com.gravityray.examples.mvvm.activities.MainActivity;
import com.gravityray.examples.mvvm.di.OfActivity;
import com.gravityray.examples.mvvm.di.ViewModelFactory;
import com.gravityray.examples.mvvm.di.ViewModelKey;
import com.gravityray.examples.mvvm.viewmodels.MainActivityViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;


@Module(includes = MainActivityContentModule.ViewModelModule.class)
public class MainActivityContentModule {
    @Module
    public abstract class ViewModelModule {
        @Binds
        @IntoMap
        @ViewModelKey(MainActivityViewModel.class)
        public abstract ViewModel mainActivityViewModel(MainActivityViewModel viewModel);
    }

    @Provides
    @OfActivity
    public ViewModelProvider provideViewModelProvider(
            MainActivity activity,
            ViewModelFactory viewModelFactory) {
        return ViewModelProviders.of(activity, viewModelFactory);
    }
}
