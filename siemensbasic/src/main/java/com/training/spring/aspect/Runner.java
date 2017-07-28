package com.training.spring.aspect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {
    @Autowired
    private Caller caller;

    @Override
    public void run(String... strings) throws Exception {
        caller.callCalled();
    }

}
