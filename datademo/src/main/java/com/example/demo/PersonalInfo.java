package com.example.demo;

import javax.persistence.*;

@Entity
public class PersonalInfo {
    @Id
    @GeneratedValue
    private int id;
    private String spouseName;
    private int marriageYear;

    @OneToOne(cascade = CascadeType.ALL)
    private Employee employee;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSpouseName() {
        return spouseName;
    }

    public void setSpouseName(String spouseName) {
        this.spouseName = spouseName;
    }

    public int getMarriageYear() {
        return marriageYear;
    }

    public void setMarriageYear(int marriageYear) {
        this.marriageYear = marriageYear;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
