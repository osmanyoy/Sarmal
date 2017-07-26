package com.training.spring.customer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
public class CustomerConfiguration {

    @Bean
    public ICustomerDAO getDAO(@Value("${server.prop.dao.type}") EDAOType type) {
        switch (type) {
            case FILE:
                return new FileCustomerDAO();
            case DB:
                return new DBCustomerDAO();
            default:
                return new DBCustomerDAO();
        }
    }

    @Bean
    public CustomerCache customerCache() {
        return new CustomerCache();
    }

    @Bean
    public CustomerManager customerManager() {
        return new CustomerManager();
    }
}
