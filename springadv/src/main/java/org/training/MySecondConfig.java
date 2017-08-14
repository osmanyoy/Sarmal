package org.training;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MySecondConfig {

    @Bean
    public Person person(){
        return new Person();
    }

}
