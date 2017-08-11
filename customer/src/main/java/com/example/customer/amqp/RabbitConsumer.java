package com.example.customer.amqp;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@RabbitListener(queues = "training.queue.siemens")
public class RabbitConsumer {

    @RabbitHandler
    public void handleMessage(String msg){
        System.out.println("Rabbit message consumed : " + msg);
    }

}
