package com.siemens.amqp.rabbittest;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.UUID;


public class MessageSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private int count;

    @Scheduled(fixedDelay = 5000)
    public void send() {
        Employee employee = new Employee();
        employee.setId(UUID.randomUUID()
                           .toString());
        employee.setAge(count);
        employee.setName("osman" + count);

        rabbitTemplate.convertAndSend("exchange1",
                                      "a.b.c",
                                      employee);

        rabbitTemplate.convertAndSend("exchange1",
                                      "a.b.c",
                                      "Message " + count++);


    }

}
