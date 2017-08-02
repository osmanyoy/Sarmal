package com.example.demo.integration;

/**
 * Created by Osman on 2.08.2017.
 */
public class Person {
    private String name;
    private String surname;
    private int age;
    private long routingTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\'' + ", surname='" + surname + '\'' + ", age=" + age + ", routingTime=" + routingTime + '}';
    }

    public long getRoutingTime() {
        return routingTime;
    }

    public void setRoutingTime(long routingTime) {
        this.routingTime = routingTime;
    }
}
