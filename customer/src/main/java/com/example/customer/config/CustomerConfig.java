package com.example.customer.config;

import com.example.customer.EDAOType;
import com.example.customer.dao.DBCustomerDAO;
import com.example.customer.dao.DBRoleDAO;
import com.example.customer.dao.FileCustomerDAO;
import com.example.customer.dao.ICutomerDAO;
import com.example.customer.manager.CustomerCache;
import com.example.customer.manager.CustomerManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
@Profile({"live","development"})
public class CustomerConfig {

    @Bean
    @Primary
    @Lazy
    public ICutomerDAO cutomerDAO(@Value("${siemens.basic.customer.daotype}") EDAOType edaoType){
        switch (edaoType){
            case FILE:
                return new FileCustomerDAO();
            case DB:
                return new DBCustomerDAO();

        }
        return new DBCustomerDAO();
    }

    @Bean
    public ICutomerDAO cutomerDAOFromBean(@Value("#{myDAOChooser.chooseDAOType()}") EDAOType edaoType){
        switch (edaoType){
            case FILE:
                return new FileCustomerDAO();
            case DB:
                return new DBCustomerDAO();

        }
        return new DBCustomerDAO();
    }

    @Bean
    public DBRoleDAO dbRoleDAO(){
        return new DBRoleDAO();
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
