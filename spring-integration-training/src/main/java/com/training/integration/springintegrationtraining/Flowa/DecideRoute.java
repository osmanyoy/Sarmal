package com.training.integration.springintegrationtraining.Flowa;

import com.training.integration.springintegrationtraining.Person;
import org.springframework.stereotype.Component;

@Component
public class DecideRoute {
    public boolean decide(Person per){
        if (per.getAge() > 40){
            return true;
        }
        return false;
    }
}
