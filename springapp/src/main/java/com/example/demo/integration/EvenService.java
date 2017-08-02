package com.example.demo.integration;

import org.springframework.messaging.Message;

/**
 * Created by Osman on 2.08.2017.
 */
public class EvenService {
    public Person yaz(Message<Person> msg){
        System.out.println("Even : " + msg.getPayload());
        return msg.getPayload();
    }
}
