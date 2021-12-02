package com.shivam.amazonlocker.service;

import com.shivam.amazonlocker.model.notification.Message;

public class ConsoleNotificationService implements NotificationService{

    @Override
    public void sendMessage(Message message) {
        System.out.println(message.getMessage());
    }
}
