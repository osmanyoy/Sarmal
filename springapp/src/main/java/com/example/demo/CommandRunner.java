package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.stereotype.Component;

@Component
public class CommandRunner implements CommandLineRunner{
    @Autowired
    private ApplicationEventMulticaster applicationEventMulticaster;

    @Override
    public void run(String... strings) throws Exception {
        MyApplicationEvent myApplicationEvent = new MyApplicationEvent();
        myApplicationEvent.setDesc("Test");
        applicationEventMulticaster.multicastEvent(myApplicationEvent);
    }
}
