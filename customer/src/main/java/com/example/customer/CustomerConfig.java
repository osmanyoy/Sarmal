package com.example.customer;

import com.example.customer.dao.FileCustomerDAO;
import com.example.customer.dao.ICutomerDAO;
import com.example.customer.manager.CustomerCache;
import com.example.customer.manager.CustomerManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfig {

    @Bean
    public ICutomerDAO cutomerDAO(){
        return new FileCustomerDAO();
    }

    @Bean
    public CustomerManager customerManager(){
        return new CustomerManager();
    }

    @Bean
    public CustomerCache customerCache(){
        return new CustomerCache();
    }

}
