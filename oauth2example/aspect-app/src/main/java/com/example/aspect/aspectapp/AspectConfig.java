package com.example.aspect.aspectapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AspectConfig {
    @Bean
    public Callee callee(){
        return new Callee();
    }

    @Bean
    public Caller caller(){
        return new Caller();
    }
}
