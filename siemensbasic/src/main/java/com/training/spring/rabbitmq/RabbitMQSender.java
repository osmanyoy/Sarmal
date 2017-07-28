package com.training.spring.rabbitmq;

import com.training.spring.customer.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class RabbitMQSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Scheduled(fixedDelay = 10000)
    public void sendPeriodicMessage(){
        rabbitTemplate.convertAndSend("siemens.exchange","siemens.routing.bir","Test");
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
