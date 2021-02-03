package com.au.kafka.question_one;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class KafkaController {

    @Autowired
    Producer producer;

    @GetMapping(value = "listener")
    public String produce(@RequestParam("message") String message) {
        producer.send(message);
        return "Message sent to the Kafka Topic Successfully";
    }
}