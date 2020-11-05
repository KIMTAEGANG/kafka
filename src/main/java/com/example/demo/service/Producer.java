package com.example.demo.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {
    private static final Logger logger = LoggerFactory.getLogger(Producer.class);
    private static final String TOPIC = "users";
    private static final String TOPIC1 = "users1";
    private static final String TOPIC2 = "users2";

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public Producer(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message){
        logger.info(String.format("#### ->Producing message -> %s", message));
        this.kafkaTemplate.send(TOPIC, message);
        this.kafkaTemplate.send(TOPIC1, message);
        this.kafkaTemplate.send(TOPIC2, message);
    }
}
