package com.simple.kafka.hello.world.receiver;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

public class Receiver{

    public static final Logger LOGGER = LoggerFactory.getLogger(Logger.class);

    CountDownLatch latch = new CountDownLatch(1);

    public CountDownLatch getLatch(){
        return latch;
    }
   
    @KafkaListener(topics = "helloworld.t")
    public void receive(String payload){
        LOGGER.info("received payload='{}'", payload);
        latch.countDown();
    }
}