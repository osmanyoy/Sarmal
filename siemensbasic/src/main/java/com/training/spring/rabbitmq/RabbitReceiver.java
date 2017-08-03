package com.training.spring.rabbitmq;

import com.training.spring.customer.Customer;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.SendTo;

@RabbitListener(queues = {RabbitMQConfig.SIMPLE_MESSAGE_QUEUE})
public class RabbitReceiver {

    @RabbitHandler
    @SendTo("exchange1")
    public String handleMessage(String str) {
        System.out.println("I received : " + str);

        return "test";
    }
}
