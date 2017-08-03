package com.example.demo.integration;

import org.springframework.messaging.Message;

/**
 * Created by Osman on 3.08.2017.
 */
public class HttpReplyListener {

    public void receiveMessage(Message<Person> message){
        System.out.println("HTTP Message : " + message.getPayload());
    }
}
