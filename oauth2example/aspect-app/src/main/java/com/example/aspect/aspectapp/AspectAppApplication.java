package com.example.aspect.aspectapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class AspectAppApplication implements ApplicationRunner{

	@Autowired
	private Caller caller;

	public static void main(String[] args) {
		SpringApplication.run(AspectAppApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments applicationArguments) throws
															   Exception {
		caller.callStarter();
	}
}
