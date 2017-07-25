package com.training.spring.customer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfiguration {

    @Bean
    public ICustomerDAO getDAO(){
        return new FileCustomerDAO();
    }

    @Bean
    public CustomerCache customerCache(){
     return new CustomerCache();
    }

    @Bean
    public CustomerManager customerManager(){
        return new CustomerManager();
    }
}
