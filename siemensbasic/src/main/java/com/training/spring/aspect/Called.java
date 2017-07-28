package com.training.spring.aspect;

/**
 * Created by Osman on 28.07.2017.
 */
public class Called {

    public String hello(String name){
        return "Hello world " + name;
    }

    @Security(role = "ADMIN")
    public String hello2(String name){
        return "Hello world " + name;
    }


}
