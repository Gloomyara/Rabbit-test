package ru.antonovmikhail.activity.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import ru.antonovmikhail.message.MessageModel;


@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final RabbitTemplate rabbitTemplate;

    @Override
    @SneakyThrows
    public void notifyUser(MessageModel message) {
        System.out.println("Уведомляю");
        Thread.sleep(100);
        System.out.println("Уведомил");
    }
}
