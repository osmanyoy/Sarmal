package com.training.spring.oauth.resourceserver.controllers;

import com.training.spring.oauth.resourceserver.entities.Person;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.UUID;

@RestController
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ResourceController {

    @GetMapping("/")
    public String index() {
        return "Hello!";
    }

    @GetMapping("/person")
    @PreAuthorize("#oauth2.hasScope('read')")
    public Person getPerson(Principal principal) {
        Person person = new Person();
        person.setId(UUID.randomUUID().toString());
        person.setFirstName("Osman");
        person.setLastName("Yaycioglu");

        return person;
    }
}
