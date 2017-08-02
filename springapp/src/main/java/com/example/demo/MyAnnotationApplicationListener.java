package com.example.demo;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MyAnnotationApplicationListener {

    @EventListener
    public void listenAppEvents(ApplicationEvent applicationEvent){
        System.out.println("All Events :" + applicationEvent );
    }
}
