package com.example.demo.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebSecurity
public class SecurityLocalConf extends WebSecurityConfigurerAdapter {

    public SecurityLocalConf(){
        // super(false);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/person")
            .anonymous()
            .antMatchers("/*")
            .authenticated()
            .and()
            .httpBasic();
    }





}
