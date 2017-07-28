package com.training.spring.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                    authorizeRequests()
            .antMatchers("/manage/**")
            .anonymous()
            .antMatchers("/**")
            .authenticated()
            .and()
            .httpBasic();
    }

    //    @Override
    //    public void configure(HttpSecurity http) throws Exception {
    //        http.authorizeRequests()
    //            .anyRequest()
    //            .authenticated()
    //            .and()
    //            .httpBasic();
    //    }

}
