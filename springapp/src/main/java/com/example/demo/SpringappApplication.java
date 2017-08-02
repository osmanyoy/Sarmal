package com.example.demo;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@ServletComponentScan
@EnableAspectJAutoProxy
public class SpringappApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringappApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments applicationArguments) throws Exception {

	}
}
