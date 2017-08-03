package com.training.spring.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

@Controller
@EnableWebSocket
public class GreetingController {

	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public HelloMessage greeting(final Greeting message) throws Exception {
		Thread.sleep(1000); // simulated delay
		System.out.println("test : " + message);
		return new HelloMessage("Hello, " + message + "!");
	}

}
