package com.example.demo.integration;

import org.springframework.integration.router.AbstractMessageRouter;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

import java.util.Collection;

/**
 * Created by Osman on 3.08.2017.
 */
public class CustomRouter extends AbstractMessageRouter {


    @Override
    protected Collection<MessageChannel> determineTargetChannels(Message<?> message) {
        return null;
    }

}
