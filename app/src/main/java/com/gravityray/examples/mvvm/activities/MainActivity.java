package com.gravityray.examples.mvvm.activities;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.gravityray.examples.mvvm.R;
import com.gravityray.examples.mvvm.di.OfActivity;
import com.gravityray.examples.mvvm.viewmodels.MainActivityViewModel;
import com.jakewharton.rxbinding2.view.RxView;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.DaggerAppCompatActivity;
import io.reactivex.disposables.CompositeDisposable;

public class MainActivity extends DaggerAppCompatActivity {

    @BindView(R.id.messages_sample_button)
    Button messagesSampleButton;

    @Inject
    @OfActivity
    ViewModelProvider viewModelProvider;

    private MainActivityViewModel viewModel;

    private CompositeDisposable startedUiCompositeDisposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        viewModel = viewModelProvider.get(MainActivityViewModel.class);

        startedUiCompositeDisposable = new CompositeDisposable();
    }

    @Override
    protected void onStart() {
        super.onStart();

        startedUiCompositeDisposable.addAll(
                viewModel.getOnOpenMessagesSample()
                        .subscribe(o -> onOpenMessagesSample()),
                RxView.clicks(messagesSampleButton)
                        .throttleFirst(300, TimeUnit.MILLISECONDS)
                        .subscribe(o -> viewModel.openMessagesSample()));
    }

    @Override
    protected void onStop() {
        super.onStop();
        startedUiCompositeDisposable.clear();
    }

    private void onOpenMessagesSample() {
        startActivity(new Intent(this, MessageListActivity.class));
    }
}
