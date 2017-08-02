package com.example.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;

@Configuration
@Profile("development")
public class SAConfigurationDevelopment {

    @Bean({"device1","device2"})
    @Scope("prototype")
    public Device deviceCreate(){
        return new Device();
    }

    @Bean
    public Device deviceMethod1(){
        return new Device();
    }

    @Bean(initMethod = "myInit",destroyMethod = "destroy")
    @Qualifier("ahmet")
    public Device deviceMethod2(){
        return new Device();
    }

    @Bean
    @Mehmet
    public Device deviceMethod3(){
        return new Device();
    }

}
