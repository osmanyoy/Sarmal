package com.training.spring.springadv.management;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

@Component
public class MyHealthIndicator implements HealthIndicator{

    @Override
    public Health health() {
        return Health.status(Status.DOWN).withDetail("myDetail","Test").build();
    }
}
