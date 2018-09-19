package com.gravityray.examples.mvvm.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.gravityray.examples.mvvm.models.database.MessageEntity;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public abstract class MessageDao {

    @Query("SELECT * FROM Messages")
    public abstract Flowable<List<MessageEntity>> getAllMessages();

    @Query("SELECT * FROM Messages WHERE _id=:messageId")
    public abstract Flowable<MessageEntity> getMessage(int messageId);

    @Insert
    public abstract void createMessage(MessageEntity message);

    @Query("DELETE FROM Messages WHERE _id=:messageId")
    public abstract void deleteMessage(int messageId);

    @Update
    public abstract void updateMessage(MessageEntity message);
}
