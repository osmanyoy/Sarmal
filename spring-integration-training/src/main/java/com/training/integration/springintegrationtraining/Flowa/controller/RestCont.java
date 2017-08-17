package com.training.integration.springintegrationtraining.Flowa.controller;

import com.training.integration.springintegrationtraining.Person;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestCont {

    @RequestMapping(value = "/createPerson",method = RequestMethod.POST)
    public String createPerson(@RequestBody Person person){
        System.out.println("Person from http :" + person);
        return "created";
    }
}
