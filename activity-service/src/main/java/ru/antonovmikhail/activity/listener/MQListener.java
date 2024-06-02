package ru.antonovmikhail.activity.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import ru.antonovmikhail.activity.service.NotificationService;
import ru.antonovmikhail.message.MessageModel;

import static ru.antonovmikhail.activity.configuration.MQConfiguration.*;

@Slf4j
@EnableRabbit
@RequiredArgsConstructor
public class MQListener {

    private final NotificationService service;

    @RabbitListener(queues = {QUEUE_WTVR, QUEUE_COMM, QUEUE_LIKE})
    public void listen(MessageModel message) {
        log.info("{} read from smthn!", message);
        service.notifyUser(message);
    }
}
