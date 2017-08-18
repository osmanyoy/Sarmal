package com.training.security.authserver;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws
                                                Exception {
        http.formLogin()
            .permitAll()
            .and()
            .requestMatchers()
            .antMatchers("/",
                         "/login",
                         "/oauth/authorize",
                         "/oauth/confirm_access")
            .and()
            .authorizeRequests()
            .anyRequest()
            .authenticated();


        http.formLogin()
            .permitAll()
            .and()
            .requestMatchers()
            .antMatchers("/",
                         "/login",
                         "/oauth/authorize",
                         "/oauth/confirm_access")
            .and()
            .authorizeRequests()
            .anyRequest()
            .authenticated();
    }
}
