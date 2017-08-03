package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class MySecurityConf {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private MyCustomUserDetals myCustomUserDetals;

    @Autowired
    public void confAuth(AuthenticationManagerBuilder managerBuilder) throws Exception {
        managerBuilder.userDetailsService(myCustomUserDetals)
                      .passwordEncoder(passwordEncoder());
    }

}
