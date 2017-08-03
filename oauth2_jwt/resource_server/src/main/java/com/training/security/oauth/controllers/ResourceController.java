package com.training.security.oauth.controllers;

import com.training.security.oauth.entities.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class ResourceController {

    @GetMapping("/")
    public String index() {
        return "Hello!";
    }

    @GetMapping("/person")
    public Person getPerson() {
        Person person = new Person();
        person.setId(UUID.randomUUID().toString());
        person.setFirstName("Osman");
        person.setLastName("Yaycıoğlu");

        return person;
    }
}
