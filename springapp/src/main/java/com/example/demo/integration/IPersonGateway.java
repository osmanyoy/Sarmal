package com.example.demo.integration;

import java.util.concurrent.Future;

/**
 * Created by Osman on 2.08.2017.
 */
public interface IPersonGateway {
    public Future<Person> sendPerson(Person person);
}
