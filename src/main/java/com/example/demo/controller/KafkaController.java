package com.example.demo.controller;

import com.example.demo.service.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {
    private final Producer producer;

    @Autowired
    KafkaController(Producer producer){
        this.producer = producer;
    }

    @GetMapping(value = "/kafka")
    public String sendMessageToKafkaTopic(@RequestParam("message") String message){
        this.producer.sendMessage(message);
        return message;
    }
}
