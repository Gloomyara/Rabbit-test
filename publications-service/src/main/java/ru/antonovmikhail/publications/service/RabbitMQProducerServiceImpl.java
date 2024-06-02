package ru.antonovmikhail.publications.service;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import ru.antonovmikhail.message.MessageModel;

import static ru.antonovmikhail.publications.configuration.MQConfiguration.exchangeName;

@Service
@RequiredArgsConstructor
public class RabbitMQProducerServiceImpl implements RabbitMQProducerService {

    private final RabbitTemplate rabbitTemplate;

    @Override
    public void sendMessage(MessageModel message) {
        rabbitTemplate.convertAndSend(exchangeName, message.getRoutingKey(), message);
    }

}
