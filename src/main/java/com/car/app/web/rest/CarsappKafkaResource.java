package com.car.app.web.rest;

import com.car.app.service.CarsappKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/carsapp-kafka")
public class CarsappKafkaResource {

    private final Logger log = LoggerFactory.getLogger(CarsappKafkaResource.class);

    private CarsappKafkaProducer kafkaProducer;

    public CarsappKafkaResource(CarsappKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.kafkaProducer.sendMessage(message);
    }
}
