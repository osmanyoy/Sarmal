package com.training.spring.rabbitmq;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

public class RabbitConsumer implements MessageListener {

    @Override
    public void onMessage(Message message) {
        byte[] body = message.getBody();
        System.out.println("I receive : " + body);
    }
}
