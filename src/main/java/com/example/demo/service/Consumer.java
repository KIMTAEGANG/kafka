package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class Consumer {

    private final Logger logger = LoggerFactory.getLogger(Consumer.class);

    @KafkaListener(topics = "users", groupId = "group_id")
    public void consume(String message) throws IOException {
        logger.info(String.format("#### -> Consumed message -> %s",message));
    }

    @KafkaListener(topics = "users1", groupId = "group_id2")
    public void consume1(String message) throws IOException {
        logger.info(String.format("#### -> Consumed message1 -> %s",message));
    }

    @KafkaListener(topics = "users2", groupId = "group_id3")
    public void consume2(String message) throws IOException {
        logger.info(String.format("#### -> Consumed message2 -> %s",message));
    }
}
