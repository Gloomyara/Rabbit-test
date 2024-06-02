package ru.antonovmikhail.activity.service;

import ru.antonovmikhail.message.MessageModel;

public interface NotificationService {

    void notifyUser(MessageModel message);
}
