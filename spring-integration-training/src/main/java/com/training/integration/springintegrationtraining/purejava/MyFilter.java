package com.training.integration.springintegrationtraining.purejava;

import com.training.integration.springintegrationtraining.Person;
import org.springframework.integration.annotation.Filter;

public class MyFilter {

    @Filter(inputChannel = "firstJavaChannel",
            outputChannel = "secondJavaChannel",
            discardChannel = "discardJavaChannel")
    public boolean filterMe(Person per) {
        return per.getAge() > 40;
    }
}
