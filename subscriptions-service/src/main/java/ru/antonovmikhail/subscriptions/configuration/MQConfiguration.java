package ru.antonovmikhail.subscriptions.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MQConfiguration {
    public static final String listenerQueueName = "новые_публикации";
    public static final String senderQueueName = "уведомления_подписчикам";
    public static final String exchangeName = "subExchange";
    public static final String routingKey = "notification";

    @Bean
    public Queue listenerQueue() {
        return new Queue(listenerQueueName, false);
    }

    @Bean
    public Queue senderQueue() {
        return new Queue(senderQueueName, false);
    }

    @Bean
    DirectExchange exchange() {
        return new DirectExchange(exchangeName, false, false);
    }

    @Bean
    Binding senderBinding(Queue senderQueue, DirectExchange exchange) {
        return BindingBuilder.bind(senderQueue).to(exchange).with(routingKey);
    }
}
