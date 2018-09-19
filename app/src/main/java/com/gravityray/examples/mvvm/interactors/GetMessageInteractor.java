package com.gravityray.examples.mvvm.interactors;


import com.gravityray.examples.mvvm.actions.ConvertMessageEntityToMessageAction;
import com.gravityray.examples.mvvm.database.MessageDao;
import com.gravityray.examples.mvvm.models.ui.Message;

import javax.inject.Inject;

import io.reactivex.Flowable;

public class GetMessageInteractor {

    private final MessageDao messageDao;
    private final ConvertMessageEntityToMessageAction convertMessageEntityToMessageAction;

    @Inject
    public GetMessageInteractor(
            MessageDao messageDao,
            ConvertMessageEntityToMessageAction convertMessageEntityToMessageAction) {
        this.messageDao = messageDao;
        this.convertMessageEntityToMessageAction = convertMessageEntityToMessageAction;
    }

    public Flowable<Message> get(int messageId) {
        return messageDao.getMessage(messageId)
                .map(convertMessageEntityToMessageAction::convert);
    }
}
