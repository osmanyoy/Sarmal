package com.example.demo;

import org.springframework.boot.actuate.endpoint.Endpoint;
import org.springframework.stereotype.Component;

@Component
public class MyEndpoint implements Endpoint<String> {

    @Override
    public String getId() {
        return "testEndpoint";
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean isSensitive() {
        return false;
    }

    @Override
    public String invoke() {
        return "test endpoint uygulama";
    }
}
