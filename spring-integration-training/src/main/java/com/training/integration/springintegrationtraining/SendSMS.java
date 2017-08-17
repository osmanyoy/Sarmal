package com.training.integration.springintegrationtraining;

import org.springframework.integration.annotation.ServiceActivator;

public class SendSMS {

    @ServiceActivator(inputChannel = "sendChannel")
    public void send(Person person) {
        System.out.println("SMS sent to : " + person.getName());
    }

}
