package com.training.integration.springintegrationtraining.purejava;

import com.training.integration.springintegrationtraining.Person;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.stereotype.Component;

@MessagingGateway
public interface IMyJavaGteway {

    @Gateway(requestChannel = "firstJavaChannel")
    String startJava(Person per);
}
