package com.training.integration.springintegrationtraining;

import org.springframework.messaging.Message;

import java.io.File;
import java.nio.file.Files;

public class FirstConsumer {

    public String handle(Person pr){
        System.out.println(pr);
        return pr.toString();
    }

}
