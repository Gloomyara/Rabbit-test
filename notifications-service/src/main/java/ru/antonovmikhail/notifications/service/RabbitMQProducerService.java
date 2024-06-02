package ru.antonovmikhail.notifications.service;


import ru.antonovmikhail.message.MessageModel;

public interface RabbitMQProducerService {

    void sendMessage(MessageModel message);
}
