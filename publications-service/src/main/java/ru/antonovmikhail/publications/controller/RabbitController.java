package ru.antonovmikhail.publications.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.antonovmikhail.message.MessageModel;
import ru.antonovmikhail.publications.service.RabbitMQProducerService;

import static ru.antonovmikhail.publications.configuration.MQConfiguration.exchangeName;


@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/publication")
public class RabbitController {

    private final RabbitMQProducerService service;

    @PostMapping
    public ResponseEntity<String> sendMessage(@RequestBody MessageModel message) {
        service.sendMessage(message);
        log.info("{} is send!", message);
        return ResponseEntity.ok().body(String.format("Send to %s !", exchangeName));
    }

    @GetMapping("/health")
    public String healthCheck() {
        return "OK";
    }
}