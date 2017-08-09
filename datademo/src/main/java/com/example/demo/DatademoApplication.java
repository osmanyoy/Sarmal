package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DatademoApplication implements ApplicationRunner {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeCRUD employeeCRUD;

    public static void main(String[] args) {
        SpringApplication.run(DatademoApplication.class,
                              args);
    }


    @Override

    public void run(ApplicationArguments applicationArguments) throws Exception {
        Employee employee = new Employee();
        employee.setName("osman");
        employee.setSurname("yay");
        employee.setUsername("osman");
        employee.setPassword("osman12");
        PersonalInfo perInfo = new PersonalInfo();
        perInfo.setMarriageYear(2005);
        perInfo.setSpouseName("Nil");
        perInfo.setEmployee(employee);
        employee.setPersonalInfo(perInfo);

        PersonalData personalData = new PersonalData();
        personalData.setHeight(200);
        personalData.setWeight(92);
        personalData.setGender(EGender.MALE);

        employee.setPersonalData(personalData);

        Department department = new Department();
        department.setDepartment("Test");
        department.setDesc1("Test department");
        employee.setDepartment(department);

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee);

        department.setEmployees(employeeList);

        // employeeRepository.save(employee);
        employeeCRUD.save(employee);

        List<Employee> listOfEmployees = employeeCRUD.findByName("osman");
        System.out.println(listOfEmployees);

    }
}
