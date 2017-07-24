package com.training.spring;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("kisi")
@Scope("prototype")
public class Person {

    private String name;
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\'' + ", phone='" + phone + '\'' + '}';
    }
}
