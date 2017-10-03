package com.siemens.amqp.rabbittest;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;

@RabbitListener(bindings = @QueueBinding(value = @Queue(value = "osman.queue3"),
                                         exchange = @Exchange(value = "exchange2",
                                                              type = ExchangeTypes.DIRECT),
                                         key = "a.b.e"))
public class Receiver4 {

    @RabbitHandler
    public void handleMessage(String str) {
        System.out.println("Message listener 4 : " + str);
    }
}
