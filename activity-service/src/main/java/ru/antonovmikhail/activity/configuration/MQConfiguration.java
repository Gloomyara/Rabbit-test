package ru.antonovmikhail.activity.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MQConfiguration {
    public static final String QUEUE_LIKE = "новый_лайк";
    public static final String QUEUE_COMM = "новый_комментарий";
    public static final String QUEUE_WTVR = "новый_wtvr";

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
}
