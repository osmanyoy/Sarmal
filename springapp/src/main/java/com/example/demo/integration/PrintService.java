package com.example.demo.integration;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;

import java.util.Map;
import java.util.Set;

public class PrintService {

    public Message<String> print(Message<String> message) {
        System.out.println("payload : " + message.getPayload());
        MessageHeaders headers = message.getHeaders();
        Set<Map.Entry<String, Object>> entries = headers.entrySet();
        for (Map.Entry<String, Object> entry : entries) {

            System.out.println("Header key : " + entry.getKey() + " value : " + entry.getValue());
        }
        return MessageBuilder.withPayload("sonraki message").build();
    }
}
