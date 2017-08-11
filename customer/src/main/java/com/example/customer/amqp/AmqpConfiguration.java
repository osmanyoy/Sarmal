package com.example.customer.amqp;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.backoff.ExponentialBackOffPolicy;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Configuration
@EnableScheduling
@EnableRabbit
public class AmqpConfiguration {
    public static final String SIMPLE_MESSAGE_QUEUE = "training.queue.siemens";

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory("localhost");
        connectionFactory.setUsername("osman");
        connectionFactory.setPassword("osman12");
        return connectionFactory;
    }

    @Bean
    public AmqpAdmin amqpAdmin() {
        RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory());
        return rabbitAdmin;
    }

    @Bean
    public TopicExchange exchange() {
        TopicExchange directExchange = new TopicExchange("siemens.exchange");
        return directExchange;
    }

    @Bean
    public Queue simpleQueue() {
        return new Queue(SIMPLE_MESSAGE_QUEUE);
    }

    @Bean
    public Queue secondQueue() {
        return new Queue("second.test.queue");
    }

    @Bean
    Binding binding(Queue simpleQueue,
                    TopicExchange exchange) {
        return BindingBuilder.bind(simpleQueue)
                             .to(exchange)
                             .with("siemens.routing.*");
    }

    @Bean
    Binding binding2(Queue secondQueue,
                     TopicExchange exchange) {
        return BindingBuilder.bind(secondQueue)
                             .to(exchange)
                             .with("osman.*");
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate template = new RabbitTemplate(connectionFactory());
        template.setRoutingKey("osman.test");
        RetryTemplate retryTemplate = new RetryTemplate();
        ExponentialBackOffPolicy exponentialBackOffPolicy = new ExponentialBackOffPolicy();
        exponentialBackOffPolicy.setInitialInterval(1000);
        exponentialBackOffPolicy.setMaxInterval(10000);
        exponentialBackOffPolicy.setMultiplier(4);
        retryTemplate.setBackOffPolicy(exponentialBackOffPolicy);
        template.setRetryTemplate(retryTemplate);
        template.setMessageConverter(jsonMessageConverter());
        return template;
    }



    @Bean
    public RabbitProducer rabbitProducer(){
        return new RabbitProducer();
    }

    @Bean
    public Executor executor(){
        return Executors.newFixedThreadPool(10);
    }

    @Bean
    public RabbitConsumer rabbitConsumer(){
        return new RabbitConsumer();
    }
}
