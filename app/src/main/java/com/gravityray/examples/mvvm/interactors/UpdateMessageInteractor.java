package com.gravityray.examples.mvvm.interactors;

import com.gravityray.examples.mvvm.actions.ConvertMessageToMessageEntityAction;
import com.gravityray.examples.mvvm.database.MessageDao;
import com.gravityray.examples.mvvm.models.ui.Message;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Single;

public class UpdateMessageInteractor {

    private final MessageDao messageDao;
    private final ConvertMessageToMessageEntityAction convertMessageToMessageEntityAction;

    @Inject
    public UpdateMessageInteractor(
            MessageDao messageDao,
            ConvertMessageToMessageEntityAction convertMessageToMessageEntityAction) {
        this.messageDao = messageDao;
        this.convertMessageToMessageEntityAction = convertMessageToMessageEntityAction;
    }

    public Completable update(final Message message) {
        return Single.just(message)
                .map(convertMessageToMessageEntityAction::convert)
                .doOnSuccess(messageDao::updateMessage)
                .toCompletable();
    }
}
