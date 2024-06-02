package ru.antonovmikhail.notifications.configuration;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Declarables;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MQConfiguration {
    public static final String QUEUE_NOTIFY = "уведомления_подписчикам";
    public static final String QUEUE_LIKE = "новый_лайк";
    public static final String QUEUE_COMM = "новый_комментарий";
    public static final String QUEUE_WTVR = "новый_wtvr";
    public static final String exchangeNotifyDirect = "x.notify";
    public static final String ROUTING_KEY_NOTIFY = "notify";
    public static final String ROUTING_KEY_LIKE = "notify.like";
    public static final String ROUTING_KEY_COMM = "notify.comm";
    public static final String ROUTING_KEY_WTVR = "notify.wtvr";


    @Bean
    public Queue queueNotify() {
        return new Queue(QUEUE_NOTIFY, false);
    }

    @Bean
    public Queue queueLike() {
        return new Queue(QUEUE_LIKE, false);
    }

    @Bean
    public Queue queueComm() {
        return new Queue(QUEUE_COMM, false);
    }

    @Bean
    public Queue queueWtvr() {
        return new Queue(QUEUE_WTVR, false);
    }

    @Bean
    DirectExchange exchange() {
        return new DirectExchange(exchangeNotifyDirect, false, false);
    }

    @Bean
    public Declarables directExchangeBindings(
            DirectExchange exchangeNotifyDirect,
            Queue queueNotify,
            Queue queueLike,
            Queue queueComm,
            Queue queueWtvr) {
        return new Declarables(
                BindingBuilder.bind(queueNotify).to(exchangeNotifyDirect).with(ROUTING_KEY_NOTIFY),
                BindingBuilder.bind(queueLike).to(exchangeNotifyDirect).with(ROUTING_KEY_LIKE),
                BindingBuilder.bind(queueComm).to(exchangeNotifyDirect).with(ROUTING_KEY_COMM),
                BindingBuilder.bind(queueWtvr).to(exchangeNotifyDirect).with(ROUTING_KEY_WTVR)
        );
    }
}
