package com.example.demo.security;

import com.example.demo.integration.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class StartupRunner implements CommandLineRunner {
    @Autowired
    private MyPersonRepository myPersonRepository;
    @Override
    public void run(String... strings) throws Exception {
        Stream.of("osman,1234,ROLE_ADMIN",
                  "ali,1234,ROLE_USER")
              .map(a -> a.split(","))
              .forEach(sp -> {
                  Person person = new Person();
                  person.setName(sp[0]);
                  person.setUsername(sp[0]);
                  person.setPassword(sp[1]);
                  person.setRole(sp[2]);
                  myPersonRepository.save(person);

              });
    }
}
