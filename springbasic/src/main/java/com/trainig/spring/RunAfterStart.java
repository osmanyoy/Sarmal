package com.trainig.spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RunAfterStart implements CommandLineRunner{

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("Commandlinerunner run ");
    }
}
