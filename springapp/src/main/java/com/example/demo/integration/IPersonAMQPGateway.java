package com.example.demo.integration;

/**
 * Created by Osman on 2.08.2017.
 */
public interface IPersonAMQPGateway {
    public void sendPersonToAMQP(Person person);
}
