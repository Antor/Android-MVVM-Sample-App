package com.gravityray.examples.mvvm.di;

import android.app.Activity;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Qualifier
@Documented
@Retention(RUNTIME)
public @interface OfActivity {
    Class<? extends Activity> value() default Activity.class;
}