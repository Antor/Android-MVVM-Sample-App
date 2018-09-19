package com.gravityray.examples.mvvm.actions;

import com.gravityray.examples.mvvm.models.database.MessageEntity;
import com.gravityray.examples.mvvm.models.ui.Message;

import javax.inject.Inject;

public class ConvertMessageToMessageEntityAction {

    @Inject
    public ConvertMessageToMessageEntityAction() {
    }

    public MessageEntity convert(Message message) {
        MessageEntity messageEntity = new MessageEntity();
        messageEntity.setId(message.getId());
        messageEntity.setTitle(message.getTitle());
        messageEntity.setText(message.getText());
        return messageEntity;
    }
}
