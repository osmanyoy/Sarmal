package com.example.demo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Base64;

@Entity
@Table(name = "employee_tablosu",indexes = {@Index(unique = false,name = "myIndex",columnList = "isim")})
@SecondaryTable(name = "employee_credential")
public class Employee implements Serializable {
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

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Employee employee = (Employee) o;

        if (employeeId != employee.employeeId) {
            return false;
        }
        if (age != employee.age) {
            return false;
        }
        if (name != null ? !name.equals(employee.name) : employee.name != null) {
            return false;
        }
        if (surname != null ? !surname.equals(employee.surname) : employee.surname != null) {
            return false;
        }
        if (username != null ? !username.equals(employee.username) : employee.username != null) {
            return false;
        }
        if (password != null ? !password.equals(employee.password) : employee.password != null) {
            return false;
        }
        if (personalInfo != null ? !personalInfo.equals(employee.personalInfo) : employee.personalInfo != null) {
            return false;
        }
        if (department != null ? !department.equals(employee.department) : employee.department != null) {
            return false;
        }
        return personalData != null ? personalData.equals(employee.personalData) : employee.personalData == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (employeeId ^ (employeeId >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (personalInfo != null ? personalInfo.hashCode() : 0);
        result = 31 * result + (department != null ? department.hashCode() : 0);
        result = 31 * result + (personalData != null ? personalData.hashCode() : 0);
        return result;
    }
}
