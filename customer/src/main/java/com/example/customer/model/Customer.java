package com.example.customer.model;


import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
public class Customer {
    @Id
    @GeneratedValue
    private long id;
    @Size(max = 30,min = 2)
    private String name;
    private String surname;
    @Min(10)
    @Max(120)
    private int age;

    @OneToOne(cascade = CascadeType.ALL)
    private CustomerCredential customerCredential;

    public Customer(){

    }

    public Customer(long l,
                    String s,
                    String s1,
                    int i) {
        id = l;
        name = s;
        surname = s1;
        age = i;
    }

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
        return "Customer{" + "name='" + name + '\'' + ", surname='" + surname + '\'' + ", age=" + age + '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CustomerCredential getCustomerCredential() {
        return customerCredential;
    }

    public void setCustomerCredential(CustomerCredential customerCredential) {
        this.customerCredential = customerCredential;
    }


}
