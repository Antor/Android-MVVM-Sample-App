package com.gravityray.examples.mvvm.di.components;

import android.app.Application;

import com.gravityray.examples.mvvm.MvvmApplication;
import com.gravityray.examples.mvvm.di.modules.ApplicationModule;
import com.gravityray.examples.mvvm.di.modules.activities.MainActivityInjectorModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;


@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,

        ApplicationModule.class,

        MainActivityInjectorModule.class
})
public interface ApplicationComponent extends AndroidInjector<MvvmApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        ApplicationComponent build();
    }
}
