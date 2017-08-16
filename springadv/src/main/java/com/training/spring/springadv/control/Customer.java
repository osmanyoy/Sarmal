package com.training.spring.springadv.control;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Customer {
    private long id;
    private String name;
    private String surname;
    private int age;

    public long getId() {
        return id;
    }

    public Customer setId(long id) {
        this.id = id;
        return this;

    }

    public String getName() {
        return name;
    }

    public Customer setName(String name) {
        this.name = name;
        return this;

    }

    public String getSurname() {
        return surname;
    }

    public Customer setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Customer setAge(int age) {
        this.age = age;
        return this;
    }
}
