package com.example.demo;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class MyHealtIndicator implements HealthIndicator{

    @Override
    public Health health() {
        return Health.down().withDetail("desc","Şu anda birşey çalışmıyor").build();
    }
}
