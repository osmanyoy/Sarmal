package com.siemens.amqp.rabbittest;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.SendTo;

@RabbitListener(queues = "osman.queue2")
public class Receiver3 {

    @RabbitHandler
    @SendTo("exchange2/a.b.e")
    public String handleMessage(String str) {
        System.out.println("Message listener 3 : " + str);
        return "new : " + str;
    }
}
