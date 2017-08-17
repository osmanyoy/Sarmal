package com.training.integration.springintegrationtraining.purejava;

import com.training.integration.springintegrationtraining.Person;
import org.springframework.integration.annotation.ServiceActivator;

public class JavaConsumer {

    @ServiceActivator(inputChannel = "secondJavaChannel")
    public String handle(Person per){
        return per.toString();
    }

    @ServiceActivator(inputChannel = "discardJavaChannel")
    public String handleDiscard(Person per){
        return "discarded : " + per.toString();
    }

}
