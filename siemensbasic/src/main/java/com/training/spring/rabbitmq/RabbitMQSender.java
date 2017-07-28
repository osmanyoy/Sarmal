package com.training.spring.rabbitmq;

import com.training.spring.customer.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;


public class RabbitMQSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    private int index = 1;

    @Scheduled(fixedDelay = 2000)
    public void sendPeriodicMessage(){
        Random random = new Random();
        int nextInt = random.nextInt(100000);
        if (nextInt % 2 == 0){
            rabbitTemplate.convertAndSend("siemens.exchange","siemens.routing.bir","Test " + index++);

        } else {
            rabbitTemplate.convertAndSend("siemens.exchange","osman.yay","Second Test " + index++);

        }
        System.out.println("sent");
        //        final Customer customer = new Customer();
        //        customer.setName("osman");
        //        customer.setSurname("yay");
        //        customer.setAge(47);
        //
        //        customer.setPassword("osman12");
        //        customer.setUsername("osman");
        //
        //        Adress adress = new Adress();
        //        adress.setCity("Adana");
        //        adress.setPostalcode(100101);
        //        adress.setStreetName("Atatürk");
        //        adress.setTown("Ceyhan");
        //
        //        customer.setAdress(adress);
        //
        //        PersonalData personalData = new PersonalData();
        //
        //        personalData.setIdentityNumber("" + UUID.randomUUID());
        //        personalData.setSpouseName("Ayşe");
        //
        //        customer.setPersonalData(personalData);
        //        personalData.setCustomer(customer);
        //
        //        List<Account> accounts = new ArrayList<>();
        //        accounts.add(new Account().setAccountName("osmanA")
        //                                  .setAccountType(EAccountType.TL)
        //                                  .setBalance(100)
        //                                  .setCustomer(customer));
        //        accounts.add(new Account().setAccountName("osmanB")
        //                                  .setAccountType(EAccountType.DOLAR)
        //                                  .setBalance(100)
        //                                  .setCustomer(customer));
        //        accounts.add(new Account().setAccountName("osmanC")
        //                                  .setAccountType(EAccountType.EURO)
        //                                  .setBalance(100)
        //                                  .setCustomer(customer));
        //
        //        customer.setAccounts(accounts);
        //
        //        rabbitTemplate.convertAndSend("siemens.exchange","siemens.routing.bir",customer);
        //        System.out.println("sent!");
    }


}
