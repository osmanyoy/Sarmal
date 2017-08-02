package com.example.demo.integration;

import org.springframework.messaging.Message;

/**
 * Created by Osman on 2.08.2017.
 */
public interface IMyGateway {
    void send(Message<String> msg);
}
