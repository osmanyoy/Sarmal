package com.example.security.authserver;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecConf extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws
                                                Exception {
        //        http.formLogin()
        //            .permitAll()
        //            .and()
        //            .authorizeRequests()
        //            .antMatchers("/login",
        //                         "/oauth/authorize")
        //            .anonymous()
        //            .and()
        //            .authorizeRequests()
        //            .anyRequest()
        //            .authenticated();

        http.csrf()
            .disable()
            .formLogin()
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
