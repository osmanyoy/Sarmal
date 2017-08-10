package com.example.customer.config;

import com.example.customer.EDAOType;
import com.example.customer.dao.DBCustomerDAO;
import com.example.customer.dao.DBRoleDAO;
import com.example.customer.dao.FileCustomerDAO;
import com.example.customer.dao.ICutomerDAO;
import com.example.customer.manager.CustomerCache;
import com.example.customer.manager.CustomerManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@Profile({"live",
          "development"})
public class CustomerConfig {

    @Autowired
    private CustomerDetailInfo detailInfo;



    @Autowired
    public void securityUygula(AuthenticationManagerBuilder managerBuilder) throws Exception {
        managerBuilder.userDetailsService(detailInfo).passwordEncoder(sifrele());

    }

    @Bean
    public BCryptPasswordEncoder sifrele(){
        return new BCryptPasswordEncoder();
    }

//    @Autowired
//    public void securityUygula(AuthenticationManagerBuilder managerBuilder) throws Exception {
//        managerBuilder.inMemoryAuthentication()
//                      .withUser("osman")
//                      .password("osman12")
//                      .roles("ADMIN","USER")
//                      .and()
//                      .withUser("nil")
//                      .password("nil12")
//                      .roles("USER");
//
//    }

    @Bean
    @Primary
    @Lazy
    public ICutomerDAO cutomerDAO(@Value("${siemens.basic.customer.daotype}") EDAOType edaoType) {
        switch (edaoType) {
            case FILE:
                return new FileCustomerDAO();
            case DB:
                return new DBCustomerDAO();

        }
        return new DBCustomerDAO();
    }

    @Bean
    public ICutomerDAO cutomerDAOFromBean(@Value("#{myDAOChooser.chooseDAOType()}") EDAOType edaoType) {
        switch (edaoType) {
            case FILE:
                return new FileCustomerDAO();
            case DB:
                return new DBCustomerDAO();

        }
        return new DBCustomerDAO();
    }

    @Bean
    public DBRoleDAO dbRoleDAO() {
        return new DBRoleDAO();
    }

    @Bean
    public CustomerManager customerManager() {
        return new CustomerManager();
    }

    @Bean
    public CustomerCache customerCache() {
        return new CustomerCache();
    }

}
