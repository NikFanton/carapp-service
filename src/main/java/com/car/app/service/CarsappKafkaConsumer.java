package com.car.app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CarsappKafkaConsumer {

    private final Logger log = LoggerFactory.getLogger(CarsappKafkaConsumer.class);
    private static final String TOPIC = "topic_carsapp";

    @KafkaListener(topics = "topic_carsapp", groupId = "group_id")
    public void consume(String message) throws IOException {
        log.info("Consumed message in {} : {}", TOPIC, message);
    }
}
