package com.training.integration.springintegrationtraining;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.ChannelInterceptor;

public class MonitorBean implements ChannelInterceptor{

    public static String toMessageStr(Message<?> message){
        if (message == null || message.getPayload() == null){
            return null;
        }
        return message.getPayload().toString();
    }

    @Override
    public Message<?> preSend(Message<?> message,
                              MessageChannel messageChannel) {
        System.out.println("PreSend : " + toMessageStr(message));
        return message;
    }

    @Override
    public void postSend(Message<?> message,
                         MessageChannel messageChannel,
                         boolean b) {
        System.out.println("PostSend : " + toMessageStr(message));

    }

    @Override
    public void afterSendCompletion(Message<?> message,
                                    MessageChannel messageChannel,
                                    boolean b,
                                    Exception e) {
        System.out.println("afterSendCompletion : " + toMessageStr(message));

    }

    @Override
    public boolean preReceive(MessageChannel messageChannel) {
        System.out.println("preReceive : " + messageChannel);
        return true;
    }

    @Override
    public Message<?> postReceive(Message<?> message,
                                  MessageChannel messageChannel) {
        System.out.println("postReceive : " + toMessageStr(message));
        return message;
    }

    @Override
    public void afterReceiveCompletion(Message<?> message,
                                       MessageChannel messageChannel,
                                       Exception e) {
        System.out.println("afterReceiveCompletion : " + toMessageStr(message));

    }
}
