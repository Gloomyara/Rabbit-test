package ru.antonovmikhail.notifications.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import ru.antonovmikhail.message.MessageModel;
import ru.antonovmikhail.notifications.configuration.MQConfiguration;
import ru.antonovmikhail.notifications.service.RabbitMQProducerService;

@Slf4j
@EnableRabbit
@RequiredArgsConstructor
public class MQListener {

    private final RabbitMQProducerService service;

    @RabbitListener(queues = MQConfiguration.QUEUE_NOTIFY)
    public void listen(MessageModel message) {
        log.info("{} read from {}!", MQConfiguration.QUEUE_NOTIFY, message);
        service.sendMessage(message);
    }
}
