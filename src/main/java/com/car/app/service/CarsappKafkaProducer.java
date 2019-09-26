package com.car.app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class CarsappKafkaProducer {

    private static final Logger log = LoggerFactory.getLogger(CarsappKafkaProducer.class);
    private static final String TOPIC = "topic_carsapp";

    private KafkaTemplate<String, String> kafkaTemplate;

    public CarsappKafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {
        log.info("Producing message to {} : {}", TOPIC, message);
        this.kafkaTemplate.send(TOPIC, message);
    }
}
