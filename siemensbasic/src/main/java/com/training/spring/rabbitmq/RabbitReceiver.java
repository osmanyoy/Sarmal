package com.training.spring.rabbitmq;

import com.training.spring.customer.Customer;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@RabbitListener(queues = {RabbitMQConfig.SIMPLE_MESSAGE_QUEUE})
public class RabbitReceiver {

    @RabbitHandler
    public void handleMessage(String str) {
        System.out.println("I received : " + str);
    }
}
