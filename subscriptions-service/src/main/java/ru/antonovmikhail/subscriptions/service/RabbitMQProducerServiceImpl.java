package ru.antonovmikhail.subscriptions.service;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import ru.antonovmikhail.message.MessageModel;

import static ru.antonovmikhail.subscriptions.configuration.MQConfiguration.exchangeName;
import static ru.antonovmikhail.subscriptions.configuration.MQConfiguration.routingKey;

@Service
@RequiredArgsConstructor
public class RabbitMQProducerServiceImpl implements RabbitMQProducerService {

    private final RabbitTemplate rabbitTemplate;

    @Override
    public void sendMessage(MessageModel message) {
        message.setRoutingKey(routingKey);
        rabbitTemplate.convertAndSend(exchangeName, routingKey, message);
    }

}
