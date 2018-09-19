package com.gravityray.examples.mvvm.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

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

    /*
     @Query("SELECT * FROM Stores")
    public abstract Flowable<List<StoreEntity>> getAllStores();

    @Query("SELECT * FROM Stores WHERE favorite=1")
    public abstract Flowable<List<StoreEntity>> getAllFavoriteStores2();

    @Insert
    public abstract void insertStore(StoreEntity storeEntity);

    @Query("UPDATE Stores SET favorite=:isFavorite WHERE _id=:id")
    public abstract void updateFavoriteStore(long id, int isFavorite);

    @Query("DELETE FROM Stores")
    public abstract void deleteAllStores();
     */
}
