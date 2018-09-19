package com.gravityray.examples.mvvm.di.modules;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.gravityray.examples.mvvm.database.MessageDao;
import com.gravityray.examples.mvvm.database.MessageDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    @Provides
    @Singleton
    public MessageDatabase provideMessageDatabase(Application application) {
        return Room.databaseBuilder(
                application,
                MessageDatabase.class,
                MessageDatabase.NAME)
                .fallbackToDestructiveMigration()
                .build();
    }

    @Provides
    public MessageDao provideNcpMobileDao(MessageDatabase ncpMobileDatabase) {
        return ncpMobileDatabase.messageDao();
    }
}
