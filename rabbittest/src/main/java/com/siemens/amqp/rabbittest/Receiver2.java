package com.siemens.amqp.rabbittest;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@RabbitListener(queues = "osman.queue1")
public class Receiver2 {

    @RabbitHandler
    public void handleMessage(String str) {
        System.out.println("Message listener 2 : " + str);
    }

    @RabbitHandler
    public void handleMessage(Employee emp) {
        System.out.println("Message listener 2 : " + emp);
    }

}
