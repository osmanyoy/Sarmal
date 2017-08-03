package com.example.demo.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.io.Serializable;

@NamedQueries({@NamedQuery(query = "select u from Person u", name = "Person.findAllCustom")})
@Entity
public class Person implements Serializable {
    @Id
    @GeneratedValue
    private long   id;
    private String username;
    private String password;
    private String role;
    private String name;
    private String surname;
    private int    age;
    private long   routingTime;

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    private static BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @PrePersist
    public void persist(){
        password = passwordEncoder.encode(password);
    }
}
