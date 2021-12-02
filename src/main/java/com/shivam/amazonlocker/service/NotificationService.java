package com.shivam.amazonlocker.service;

import com.shivam.amazonlocker.model.notification.Message;

public interface NotificationService {
    void sendMessage(Message message);
}
