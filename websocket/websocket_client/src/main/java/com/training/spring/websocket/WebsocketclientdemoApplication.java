package com.training.spring.websocket;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.socket.WebSocketHttpHeaders;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.Transport;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;

@SpringBootApplication
public class WebsocketclientdemoApplication implements ApplicationRunner {

	private SockJsClient sockJsClient;

	private WebSocketStompClient stompClient;

	private final WebSocketHttpHeaders headers = new WebSocketHttpHeaders();

	private final int port = 8080;

	private StompSessionHandlerAdapter handler;

	public static void main(final String[] args) {
		SpringApplication.run(WebsocketclientdemoApplication.class,
		                      args);
	}

	@Override
	public void run(final ApplicationArguments arg0) throws Exception {
		final List<Transport> transports = new ArrayList<>();
		transports.add(new WebSocketTransport(new StandardWebSocketClient()));
		this.sockJsClient = new SockJsClient(transports);

		this.stompClient = new WebSocketStompClient(this.sockJsClient);
		this.stompClient.setMessageConverter(new MappingJackson2MessageConverter());

		final AtomicReference<Throwable> failure = new AtomicReference<>();

		this.handler = new SessionHandler(failure);

		final ListenableFuture<StompSession> connect = this.stompClient.connect("ws://localhost:{port}/stomp",
		                                                                        this.headers,
		                                                                        this.handler,
		                                                                        this.port);

	}
}
