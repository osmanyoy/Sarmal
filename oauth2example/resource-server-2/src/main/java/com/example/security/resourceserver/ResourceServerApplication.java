package com.example.security.resourceserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableResourceServer
@RestController
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ResourceServerApplication {

	@PreAuthorize("#oauth2.hasScope('personalInfo')")
    @RequestMapping("/merInfo")
	public String person(){
		Person person = new Person();
		person.setAge(100);
		person.setName("osman");
		person.setSurname("yaycioglu");
		return person.toString();
	}

	@RequestMapping("/createContact")
	public boolean contact(){
		return true;
	}


	public static void main(String[] args) {
		SpringApplication.run(ResourceServerApplication.class, args);
	}
}
