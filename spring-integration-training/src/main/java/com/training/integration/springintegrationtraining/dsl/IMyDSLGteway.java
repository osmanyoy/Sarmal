package com.training.integration.springintegrationtraining.dsl;

import com.training.integration.springintegrationtraining.Person;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.stereotype.Component;


@MessagingGateway
public interface IMyDSLGteway {

    @Gateway(requestChannel = "firstDSLChannel",requestTimeout = 1000L,replyTimeout = 1000L)
    String startDSL(Person per);
}
