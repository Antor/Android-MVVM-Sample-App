package com.gravityray.examples.mvvm.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.gravityray.examples.mvvm.models.database.MessageEntity;


@Database(
        entities = {
                MessageEntity.class
        },
        version = 1
)
public abstract class MessageDatabase extends RoomDatabase {

    public static final String NAME = "MessageDatabase";

    public abstract MessageDao messageDao();
}
