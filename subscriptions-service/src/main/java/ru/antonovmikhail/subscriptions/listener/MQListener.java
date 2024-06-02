package ru.antonovmikhail.subscriptions.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import ru.antonovmikhail.message.MessageModel;
import ru.antonovmikhail.subscriptions.service.RabbitMQProducerService;

import static ru.antonovmikhail.subscriptions.configuration.MQConfiguration.listenerQueueName;
import static ru.antonovmikhail.subscriptions.configuration.MQConfiguration.senderQueueName;

@Slf4j
@EnableRabbit
@RequiredArgsConstructor
public class MQListener {

    private final RabbitMQProducerService service;

    @RabbitListener(queues = listenerQueueName)
    public void listen(MessageModel message) {
        log.info("{} read from {}; and is send to {}!", listenerQueueName, message, senderQueueName);
        service.sendMessage(message);
    }
}
