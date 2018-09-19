package com.gravityray.examples.mvvm.interactors;

import com.gravityray.examples.mvvm.database.MessageDao;

import javax.inject.Inject;

import io.reactivex.Completable;

public class DeleteMessageInteractor {

    private final MessageDao messageDao;

    @Inject
    public DeleteMessageInteractor(MessageDao messageDao) {
        this.messageDao = messageDao;
    }

    public Completable delete(int messageId) {
        return Completable.fromAction(() -> {
            messageDao.deleteMessage(messageId);
        });
    }
}
