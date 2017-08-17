package com.training.integration.springintegrationtraining;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:integration.xml")
public class IntegrationConfig {

    @Bean
    public SendEmail sendEmail(){
        return new SendEmail();
    }

    @Bean
    public SendSMS sendSMS(){
        return new SendSMS();
    }

}
