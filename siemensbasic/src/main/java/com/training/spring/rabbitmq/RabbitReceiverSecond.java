package com.training.spring.rabbitmq;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@RabbitListener(queues = {"second.test.queue"})
public class RabbitReceiverSecond {

    @RabbitHandler
    public void handleMessage(String str) {
        System.out.println("I received From Second: " + str);
    }
}
