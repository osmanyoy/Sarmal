package com.training.spring.aspect;

import org.springframework.beans.factory.annotation.Autowired;

public class Caller {

    @Autowired
    private Called called;

    public void callCalled(){
        String hello = called.hello("osman");
        System.out.println("Result : " + hello);
    }

}
