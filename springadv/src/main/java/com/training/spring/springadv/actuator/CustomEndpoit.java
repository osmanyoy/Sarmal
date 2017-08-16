package com.training.spring.springadv.actuator;

import org.springframework.boot.actuate.endpoint.Endpoint;
import org.springframework.stereotype.Component;

@Component
public class CustomEndpoit implements Endpoint<String>{
    @Override
    public String getId() {
        return "appInfo";
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean isSensitive() {
        return true;
    }

    @Override
    public String invoke() {
        return "Test";
    }
}
