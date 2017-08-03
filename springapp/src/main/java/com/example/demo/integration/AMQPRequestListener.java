package com.example.demo.integration;

import org.springframework.messaging.Message;

public class AMQPRequestListener {
    public void onMessage(Message<Person> msg){
        System.out.println("My message : " + msg);
    }
}
