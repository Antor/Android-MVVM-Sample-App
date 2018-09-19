package com.gravityray.examples.mvvm.interactors;

import com.gravityray.examples.mvvm.actions.ConvertMessageEntityToMessageAction;
import com.gravityray.examples.mvvm.database.MessageDao;
import com.gravityray.examples.mvvm.models.ui.Message;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

public class GetAllMessagesInteractor {

    private final MessageDao messageDao;
    private final ConvertMessageEntityToMessageAction convertMessageEntityToMessageAction;

    @Inject
    public GetAllMessagesInteractor(
            MessageDao messageDao,
            ConvertMessageEntityToMessageAction convertMessageEntityToMessageAction) {
        this.messageDao = messageDao;
        this.convertMessageEntityToMessageAction = convertMessageEntityToMessageAction;
    }

    public Flowable<List<Message>> get() {
        return messageDao.getAllMessages()
                .flatMapSingle(messageList -> Flowable.fromIterable(messageList)
                                .map(convertMessageEntityToMessageAction::convert)
                                .toList());
    }
}
