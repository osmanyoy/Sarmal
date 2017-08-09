package com.example.customer;

import com.example.customer.dao.DBCustomerDAO;
import com.example.customer.dao.FileCustomerDAO;
import com.example.customer.dao.ICutomerDAO;
import com.example.customer.manager.CustomerCache;
import com.example.customer.manager.CustomerManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class CustomerConfigTest {

    @Bean
    public ICutomerDAO fileCutomerDAO(){
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
