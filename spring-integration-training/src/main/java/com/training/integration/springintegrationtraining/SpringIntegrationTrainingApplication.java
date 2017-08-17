package com.training.integration.springintegrationtraining;

import com.training.integration.springintegrationtraining.dsl.IMyDSLGteway;
import com.training.integration.springintegrationtraining.purejava.IMyJavaGteway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@SpringBootApplication
@EnableIntegration
@IntegrationComponentScan
@EnableAsync
@EnableScheduling
public class SpringIntegrationTrainingApplication implements ApplicationRunner {

    @Autowired
    private IMyJavaGteway javaGteway;

    @Autowired
    private IMyDSLGteway myDSLGteway;

    @Autowired
    private MyGateway myGateway;


    @Autowired
    private AsyncGateway asyncGateway;


    @Bean
    public Executor executor(){
        return Executors.newFixedThreadPool(10);
    }

    @Autowired
    private AsyncTest asyncTest;

    public static void main(String[] args) {
        SpringApplication.run(SpringIntegrationTrainingApplication.class,
                              args);
    }

    @Override
    public void run(ApplicationArguments applicationArguments) throws
                                                               Exception {

        Person person1 = new Person();
        person1.setName("osman");
        person1.setAge(30);
        person1.setSurname("yay");

        ListenableFuture<String> start1 = asyncGateway.start(person1);
        start1.addCallback(new ListenableFutureCallback<String>() {
            @Override
            public void onFailure(Throwable throwable) {
                System.out.println("Failure : " + throwable.getMessage());
            }

            @Override
            public void onSuccess(String s) {
                System.out.println("Success : " + s);
            }
        });
        // Message<String> stringMessage = new GenericMessage<String>("Osman Test ");
        // directChannel.send(stringMessage);
        Future<String> stringFuture = asyncTest.callMe();
        if (stringFuture.isDone()){
            String s = stringFuture.get();
            System.out.println("Future result : " + s);
        }

        ListenableFuture<String> stringListenableFuture = asyncTest.callMeListen();
        stringListenableFuture.addCallback(new ListenableFutureCallback<String>() {
            @Override
            public void onFailure(Throwable throwable) {

            }

            @Override
            public void onSuccess(String s) {
                System.out.println(" ListenableFuture Result : " + s);
            }
        });



        String start = myDSLGteway.startDSL(person1);
        System.out.println("DSL result ---> " + start);

        start = myGateway.start(person1);
        System.out.println("XML result ---> " + start);

        start = javaGteway.startJava(person1);
        System.out.println("JAVA result ---> " + start);

        Person person2 = new Person();
        person2.setName("nil");
        person2.setAge(35);
        person2.setSurname("yay");
        //		String start2 = myGateway.start(person2);
        String start2 = javaGteway.startJava(person2);
        System.out.println(start2);

    }

//    @Scheduled(fixedDelay = 1000)
//    public void testScheduling(){
//        System.out.println("Schedule : " + Thread.currentThread().getName());
//    }
}
