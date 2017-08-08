package com.training.spring.websocket;

import java.lang.reflect.Type;

import org.springframework.messaging.simp.stomp.StompFrameHandler;
import org.springframework.messaging.simp.stomp.StompHeaders;

public class FrameHandler implements StompFrameHandler {

    @Override
    public Type getPayloadType(final StompHeaders headers) {
        return HelloMessage.class;
    }

    @Override
    public void handleFrame(final StompHeaders headers,
                            final Object payload) {
        final HelloMessage helloMessage = (HelloMessage) payload;
        System.out.println(helloMessage);
    }

}
