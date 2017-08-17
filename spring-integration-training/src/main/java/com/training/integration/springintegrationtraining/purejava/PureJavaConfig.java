package com.training.integration.springintegrationtraining.purejava;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.MessageChannel;

@Configuration
public class PureJavaConfig {

    @Bean
    public MessageChannel firstJavaChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel secondJavaChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel discardJavaChannel() {
        return new DirectChannel();
    }

    @Bean
    public MyFilter myFilter(){
        return new MyFilter();
    }

    @Bean
    public JavaConsumer javaConsumer(){
        return new JavaConsumer();
    }


}
