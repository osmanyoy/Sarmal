package com.training.security.authserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@SpringBootApplication
@EnableWebSecurity
@EnableAuthorizationServer
@EnableResourceServer
@RestController
public class AuthServerApplication {

	@RequestMapping("/user")
	public Principal principal(Principal principal){
		return 	principal;
	}


    @Autowired
    public void authConfig(AuthenticationManagerBuilder auth) throws
                                                              Exception {
        auth.inMemoryAuthentication()
            .withUser("osman")
            .password("123")
            .roles("USER",
                   "ADMIN")
            .and()
            .withUser("nil")
            .password("123")
            .roles("USER");


    }

	public static void main(String[] args) {
		SpringApplication.run(AuthServerApplication.class, args);
	}
}
