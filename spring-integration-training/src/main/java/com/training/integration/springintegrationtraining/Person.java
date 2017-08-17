package com.training.integration.springintegrationtraining;

public class Person {
    private String name;
    private String surname;
    private int age;
    private long chainTime;

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
        return "Person{" + "name='" + name + '\'' + ", surname='" + surname + '\'' + ", age=" + age + '}';
    }

    public long getChainTime() {
        return chainTime;
    }

    public void setChainTime(long chainTime) {
        this.chainTime = chainTime;
    }
}
