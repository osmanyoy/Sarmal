package com.training.spring.springadv;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

@Configuration
@Profile("test")
public class AppConfigTest {


    @Lazy
    @Bean
    @Primary
    public Device dev(){
        return new Device();
    }

    @Bean
    @Qualifier("testMest")
    public Device devTest(){
        return new Device();
    }

    @Bean
    @DeviceBean
    public Device devTest2(){
        return new Device();
    }


}
