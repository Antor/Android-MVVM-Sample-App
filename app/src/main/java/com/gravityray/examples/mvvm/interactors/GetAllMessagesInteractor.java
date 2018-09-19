package com.gravityray.examples.mvvm.interactors;

import com.gravityray.examples.mvvm.database.MessageDao;
import com.gravityray.examples.mvvm.models.database.MessageEntity;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

public class GetAllMessagesInteractor {

    private final MessageDao messageDao;

    @Inject
    public GetAllMessagesInteractor(MessageDao messageDao) {
        this.messageDao = messageDao;
    }

    public Flowable<List<MessageEntity>> get() {
        return messageDao.getAllMessages();
    }
}
