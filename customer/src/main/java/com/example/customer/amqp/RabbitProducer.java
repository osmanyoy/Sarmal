package com.example.customer.amqp;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

public class RabbitProducer {

    private int index;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Scheduled(fixedDelay = 5000)
    public void send(){
        rabbitTemplate.convertAndSend("siemens.exchange","siemens.routing.test","test message " + index++);
    }
}
