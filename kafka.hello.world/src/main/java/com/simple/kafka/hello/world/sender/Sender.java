package com.simple.kafka.hello.world.sender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

public class Sender {
    public static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    
    public void send(String payload){
        LOGGER.info("sending payload , '{}'", payload);
        kafkaTemplate.send("helloworld.t",payload);
    }
}