package com.training.spring.oauth.resourceserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ResourceServerApplication {

	@Bean
	public CustomUserInfoTokenServices customUserInfoTokenServices(){
		return new CustomUserInfoTokenServices("http://localhost:8082/auth/user",null);
	}

	public static void main(String[] args) {
		SpringApplication.run(ResourceServerApplication.class, args);
	}
}
