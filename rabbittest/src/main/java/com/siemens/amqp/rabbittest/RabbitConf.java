package com.siemens.amqp.rabbittest;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.AsyncRabbitTemplate;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.postprocessor.GZipPostProcessor;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.RetryPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.policy.TimeoutRetryPolicy;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableRabbit
@EnableScheduling
public class RabbitConf {

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory("127.0.0.1");
        cachingConnectionFactory.setUsername("osman");
        cachingConnectionFactory.setPassword("osman12");
        return cachingConnectionFactory;
    }

    @Bean
    public AmqpAdmin amqpAdmin(ConnectionFactory connectionFactory) {
        RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory);
        return rabbitAdmin;
    }

    @Bean
    public Queue queue1() {
        Queue queue = new Queue("osman.queue1");
        return queue;
    }

    @Bean
    public Queue queue2() {
        return QueueBuilder.durable("osman.queue2")
                           .withArgument("x-message-ttl",
                                         10000L)
                           .withArgument("aaa",
                                         "bbb")
                           .build();
    }


    @Bean
    public Exchange createExchange() {
        Exchange exchange = new DirectExchange("exchange1");
        return exchange;

    }

    @Bean
    public Binding createBound1(Queue queue1,
                                Exchange exchange) {
        return BindingBuilder.bind(queue1)
                             .to(exchange)
                             .with("a.b.c")
                             .noargs();
    }

    @Bean
    public Binding createBound2(Queue queue2,
                                Exchange exchange) {
        return BindingBuilder.bind(queue2)
                             .to(exchange)
                             .with("a.b.d")
                             .noargs();
    }

    @Bean
    public SimpleRabbitListenerContainerFactory simpleRabbitListenerContainerFactory() {
        SimpleRabbitListenerContainerFactory simpleRabbitListenerContainerFactory = new SimpleRabbitListenerContainerFactory();
        simpleRabbitListenerContainerFactory.setConcurrentConsumers(10);
        simpleRabbitListenerContainerFactory.setMaxConcurrentConsumers(20);
        //simpleRabbitListenerContainerFactory.setMessageConverter(new Jackson2JsonMessageConverter());
        return simpleRabbitListenerContainerFactory;
    }


    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
        //rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        // rabbitTemplate.setBeforePublishPostProcessors(new GZipPostProcessor());
//        RetryTemplate retryTemplate = new RetryTemplate();
//        TimeoutRetryPolicy retryPolicy = new TimeoutRetryPolicy();
//        retryTemplate.setRetryPolicy(retryPolicy);
//        rabbitTemplate.setRetryTemplate(retryTemplate);
        //        AsyncRabbitTemplate asyncRabbitTemplate = new AsyncRabbitTemplate();
        //        asyncRabbitTemplate.sendAndReceive(null);
        return rabbitTemplate;
    }

    @Bean
    public MessageSender messageSender() {
        return new MessageSender();
    }

    @Bean
    public Receiver1 receiver1() {
        return new Receiver1();
    }

    @Bean
    public Receiver2 receiver2() {
        return new Receiver2();
    }

    @Bean
    public Receiver3 receiver3() {
        return new Receiver3();
    }

    @Bean
    public Receiver4 receiver4() {
        return new Receiver4();
    }
}
