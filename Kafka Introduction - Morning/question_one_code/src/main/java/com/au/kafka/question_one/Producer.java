package com.au.kafka.question_one;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void send(String message) {
        kafkaTemplate.send("BeforePass", message);
    }

    @KafkaListener(topics = "BeforePass", groupId = "group_Id")
    public void consume(String message){
        kafkaTemplate.send("AfterPass",message);
        System.out.println(message);
    }

    @Bean
    public NewTopic beforePassTopic(){
        return new NewTopic("BeforePass",1,(short) 1);
    }
    @Bean
    public NewTopic afterPassTopic(){

        return new NewTopic("AfterPass",1,(short) 1);
    }
}