package com.training.spring.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
@EnableRabbit
public class RabbitMQConfig {
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
        template.setMessageConverter(jsonMessageConverter());
        return template;
    }


    @Bean
    public SimpleMessageListenerContainer listenerContainer() {
        SimpleMessageListenerContainer listenerContainer = new SimpleMessageListenerContainer();
        listenerContainer.setConnectionFactory(connectionFactory());
        listenerContainer.setQueues(simpleQueue());
        listenerContainer.setMessageConverter(jsonMessageConverter());
        listenerContainer.setMessageListener(new RabbitConsumer());
        listenerContainer.setAcknowledgeMode(AcknowledgeMode.AUTO);
        return listenerContainer;
    }

    @Bean
    public RabbitMQSender rabbitMQSender() {
        return new RabbitMQSender();
    }

    @Bean
    public RabbitReceiver rabbitReceiver() {
        return new RabbitReceiver();
    }

    @Bean
    public RabbitReceiverSecond rabbitReceiver2() {
        return new RabbitReceiverSecond();
    }

}
