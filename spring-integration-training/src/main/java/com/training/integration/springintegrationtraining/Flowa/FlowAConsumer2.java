package com.training.integration.springintegrationtraining.Flowa;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

@Component
public class FlowAConsumer2 {

    @ServiceActivator(inputChannel = "subscribeChannel")
    public String resul(String str) {
        return "FlowACunsumer2 " + str;
    }
}
