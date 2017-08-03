package com.example.demo.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.*;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.messaging.support.MessageBuilder;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;

@SpringBootApplication(scanBasePackages = {"com.example.demo"})
public class IntegrationStarter implements ApplicationRunner {

    //    @Autowired
    //    @Qualifier("myfirstchannel")
    //    private DirectChannel directChannel;

    @Autowired
    private IMyGateway iMyGateway;

    @Autowired
    private IPersonGateway personGateway;

    @Autowired
    private IHTTPRequestGateway requestGateway;

    @Autowired
    private IPersonAMQPGateway personAMQPGateway;

    @Autowired
    @Qualifier("reply.channel")
    private PollableChannel receivedChannel;

    @Autowired
    @Qualifier("get.request.channel")
    private MessageChannel  getRequestChannel;


    public static void main(String[] args) {
        SpringApplication.run(IntegrationStarter.class);
    }

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        // requestGateway.sendRequest();
//        Message<?> message = MessageBuilder.withPayload("")
//                                           .build();
//        getRequestChannel.send(message);
//        Message<?> receivedMsg = receivedChannel.receive();
//        String serverMsg = (String) receivedMsg.getPayload();
//        System.out.println(serverMsg.toString());


        Person person = new Person();
        person.setAge(46);
        person.setName("osman");
        person.setSurname("yay");

        personAMQPGateway.sendPersonToAMQP(person);

        Future<Person> personFuture = personGateway.sendPerson(person);
        Person person1 = personFuture.get();
        System.out.println("Person son sonuç : " + person1);


        //        Map<String, Object> headers = new HashMap<>();
        //        headers.put("myheader",
        //                    "value12345");
        //        Message<String> stringMessage = new GenericMessage<String>("My message",
        //                                                                   headers);

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

        //        for (int i = 0; i < 10; i++) {
        //            iMyGateway.send(MessageBuilder.withPayload("My message " + i)
        //                                             .setHeader("myheader",
        //                                                        "header" + i)
        //                                             .build());
        //        }

    }
}
