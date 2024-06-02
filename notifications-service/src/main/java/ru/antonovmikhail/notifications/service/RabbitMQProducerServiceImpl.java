package ru.antonovmikhail.notifications.service;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import ru.antonovmikhail.message.MessageModel;

import static ru.antonovmikhail.notifications.configuration.MQConfiguration.exchangeNotifyDirect;


@Service
@RequiredArgsConstructor
public class RabbitMQProducerServiceImpl implements RabbitMQProducerService {

    private final RabbitTemplate rabbitTemplate;

    @Override
    public void sendMessage(MessageModel message) {
        String newRoutingKey = String.format("%s.%s", message.getRoutingKey(), message.getActionType());
        message.setRoutingKey(newRoutingKey);
        rabbitTemplate.convertAndSend(exchangeNotifyDirect,
                newRoutingKey,
                message);
    }
}
