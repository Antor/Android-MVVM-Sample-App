package com.gravityray.examples.mvvm.viewmodels;

import android.arch.lifecycle.ViewModel;

import com.gravityray.rxeventemitter.RxEventEmitter;

import javax.inject.Inject;

import io.reactivex.Observable;

public class MainActivityViewModel extends ViewModel {

    private final RxEventEmitter<Object> onOpenMessagesSampleEmitter;

    @Inject
    public MainActivityViewModel() {
        onOpenMessagesSampleEmitter = new RxEventEmitter<>();
    }

    public Observable<Object> getOnOpenMessagesSample() {
        return onOpenMessagesSampleEmitter.observe();
    }

    public void openMessagesSample() {
        onOpenMessagesSampleEmitter.onNext(RxEventEmitter.EMPTY);
    }
}
