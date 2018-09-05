package com.gravityray.examples.mvvm.di;

import android.support.v4.app.Fragment;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Qualifier
@Documented
@Retention(RUNTIME)
public @interface OfSupportFragment {
    Class<? extends Fragment> value() default Fragment.class;
}