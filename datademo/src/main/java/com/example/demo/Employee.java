package com.example.demo;

import javax.persistence.*;
import java.util.Base64;

@Entity
@Table(name = "employee_tablosu",indexes = {@Index(unique = false,name = "myIndex",columnList = "isim")})
@SecondaryTable(name = "employee_credential")
public class Employee {
    @Id
    @GeneratedValue
    private long employeeId;
    @Column(name = "isim",length = 50,nullable = false,unique = false)
    private String name;
    @Column(name = "soyisim",nullable = true)
    private String surname;
    private int age;

    @Column(table = "employee_credential")
    private String username;
    @Column(table = "employee_credential")
    private String password;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private PersonalInfo personalInfo;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Department department;


    @Embedded
    @AttributeOverrides({@AttributeOverride(column = @Column(name = "uzunluk"),name = "height")})
    // @Transient
    private PersonalData personalData;

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


    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return "Employee{" + "employeeId=" + employeeId + ", name='" + name + '\'' + ", surname='" + surname + '\'' + '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public PersonalData getPersonalData() {
        return personalData;
    }

    public void setPersonalData(PersonalData personalData) {
        this.personalData = personalData;
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


    @PrePersist
    @PreUpdate
    public void yazmadanOnce(){
        password = new String(Base64.getEncoder().encode(password.getBytes()));
    }

    @PostLoad
    @PostUpdate
    @PostPersist
    public void yazdiktanSonra(){
        password = new String(Base64.getDecoder().decode(password.getBytes()));

    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public PersonalInfo getPersonalInfo() {
        return personalInfo;
    }

    public void setPersonalInfo(PersonalInfo personalInfo) {
        this.personalInfo = personalInfo;
    }
}
