package com.example.demo.integration;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

import java.util.Map;
import java.util.Set;

public class PrintServiceReverse {

    public void print(Message<String> message) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((String)message.getPayload());

        System.out.println("payload : " + stringBuilder.reverse().toString());
        MessageHeaders headers = message.getHeaders();
        Set<Map.Entry<String, Object>> entries = headers.entrySet();
        for (Map.Entry<String, Object> entry : entries) {

            System.out.println("Header key : " + entry.getKey() + " value : " + entry.getValue());
        }
    }
}
