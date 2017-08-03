package com.training.spring.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

	@Override
	public void configureMessageBroker(final MessageBrokerRegistry config) {
		// config.enableSimpleBroker("/topic");
		config.enableStompBrokerRelay("/topic",
		                              "/queue")
		      .setSystemLogin("osman")
		      .setSystemPasscode("osman12")
		      .setClientLogin("osman")
		      .setClientPasscode("osman12")
		      .setAutoStartup(true);
		config.setApplicationDestinationPrefixes("/app");
	}

	@Override
	public void registerStompEndpoints(final StompEndpointRegistry registry) {
		registry.addEndpoint("/stomp")
		        .withSockJS();
	}

}