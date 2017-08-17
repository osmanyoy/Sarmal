package com.training.integration.springintegrationtraining.dsl;

import com.training.integration.springintegrationtraining.Person;

public class FilterBean {
    public boolean decide(Person person){
        return person.getAge() > 40;
    }
}
