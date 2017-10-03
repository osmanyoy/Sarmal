package com.siemens.amqp.rabbittest;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.SendTo;

@RabbitListener(queues = "osman.queue1")
public class Receiver1 {

    @RabbitHandler
    public void handleMessage(String str) {
        System.out.println("Message listener 1 : " + str);
    }

    @RabbitHandler
    @SendTo("exchange1/a.b.d")
    public String handleMessage(Employee emp) {
        System.out.println("Message listener 1 : " + emp);
        return emp.getName();
    }

}
