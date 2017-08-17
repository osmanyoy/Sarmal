package com.training.integration.springintegrationtraining;

import org.springframework.integration.annotation.ServiceActivator;

public class SendEmail {

    @ServiceActivator(inputChannel = "sendChannel")
    public void send(Person person) {
        System.out.println("Mail sent to : " + person.getName());
    }

}
