package com.example.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class CustomerMain {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(CustomerApplication.class,
                                                                       args);
        CustomerApplication bean = context.getBean(CustomerApplication.class);

    }

}
