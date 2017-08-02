package com.example.demo.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.messaging.support.MessageBuilder;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class IntegrationStarter implements ApplicationRunner {

//    @Autowired
//    @Qualifier("myfirstchannel")
//    private DirectChannel directChannel;

    @Autowired
    private IMyGateway iMyGateway;

    public static void main(String[] args) {
        SpringApplication.run(IntegrationStarter.class);
    }

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        Map<String, Object> headers = new HashMap<>();
        headers.put("myheader",
                    "value12345");
        Message<String> stringMessage = new GenericMessage<String>("My message",
                                                                   headers);

//        directChannel.subscribe(new MessageHandler() {
//            @Override
//            public void handleMessage(Message<?> message) throws MessagingException {
//                String mMeassge = (String)message.getPayload();
//
//                if (mMeassge.endsWith("2")){
//                    throw new IllegalArgumentException("dsfd");
//                }
//                PrintService printService = new PrintService();
//                printService.print((Message<String>) message);
//            }
//        });
//
//        directChannel.subscribe(new MessageHandler() {
//            @Override
//            public void handleMessage(Message<?> message) throws MessagingException {
//                PrintServiceReverse printService = new PrintServiceReverse();
//                printService.print((Message<String>) message);
//            }
//        });

        for (int i = 0; i < 10; i++) {
            iMyGateway.send(MessageBuilder.withPayload("My message " + i)
                                             .setHeader("myheader",
                                                        "header" + i)
                                             .build());
        }

    }
}
