package com.gravityray.examples.mvvm.actions;

import com.gravityray.examples.mvvm.models.database.MessageEntity;
import com.gravityray.examples.mvvm.models.ui.Message;

import javax.inject.Inject;

public class ConvertMessageEntityToMessageAction {

    @Inject
    public ConvertMessageEntityToMessageAction() {
    }

    public Message convert(MessageEntity messageEntity) {
        Message message = new Message();
        message.setId(messageEntity.getId());
        message.setTitle(messageEntity.getTitle());
        message.setText(messageEntity.getText());
        return message;
    }
}
