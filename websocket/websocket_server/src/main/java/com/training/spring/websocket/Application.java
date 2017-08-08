package com.training.spring.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class Application implements ApplicationRunner {

	private int index = 0;

	@Autowired
	private SimpMessagingTemplate messaging;

	@Scheduled(fixedRate = 1000,initialDelay = 10000)
	public void sendRandomPerson() {
		final HelloMessage helloMessage = new HelloMessage();
		helloMessage.setName("test " + this.index++);
		this.messaging.convertAndSend("/topic/greetings",
		                              helloMessage);
	}

	public static void main(final String[] args) {
		SpringApplication.run(Application.class,
		                      args);
	}

	@Override
	public void run(final ApplicationArguments arg0) throws Exception {

	}

}
