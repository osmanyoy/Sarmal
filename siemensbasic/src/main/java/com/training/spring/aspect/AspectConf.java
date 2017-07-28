package com.training.spring.aspect;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AspectConf {

    @Bean
    public Enforcer enforcer() {
        return new Enforcer();
    }

    @Bean
    public Called called() {
        return new Called();
    }

    @Bean
    public Caller caller() {
        return new Caller();
    }

}
