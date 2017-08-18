package com.example.aspect.aspectapp;

import org.springframework.beans.factory.annotation.Autowired;

public class Caller {
    @Autowired
    private Callee callee;

    public void callStarter(){
        String callStarter = callee.callMe("CallStarter");
        System.out.println(callStarter);
    }
}
