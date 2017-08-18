package com.example.security.resourceserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableResourceServer
@RestController
public class ResourceServerApplication {

	@RequestMapping("/perInfo")
	public Person person(){
		Person person = new Person();
		person.setAge(100);
		person.setName("osman");
		person.setSurname("yaycioglu");
		return person;
	}

	@RequestMapping("/createContact")
	public boolean contact(){
		return true;
	}


	public static void main(String[] args) {
		SpringApplication.run(ResourceServerApplication.class, args);
	}
}
