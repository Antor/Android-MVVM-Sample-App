package com.gravityray.examples.mvvm.interactors;

import com.gravityray.examples.mvvm.database.MessageDao;
import com.gravityray.examples.mvvm.models.database.MessageEntity;

import javax.inject.Inject;

import io.reactivex.Completable;

public class CreateMessageInteractor {

    private final MessageDao messageDao;

    @Inject
    public CreateMessageInteractor(MessageDao messageDao) {
        this.messageDao = messageDao;
    }

    public Completable create() {
        return Completable.fromAction(() -> {
            MessageEntity messageEntity = new MessageEntity();
            messageEntity.setTitle("");
            messageEntity.setText("");
            messageDao.createMessage(messageEntity);
        });
    }
}
