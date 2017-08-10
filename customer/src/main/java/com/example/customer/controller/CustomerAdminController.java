package com.example.customer.controller;

import com.example.customer.model.Customer;
import com.example.customer.model.CustomerList;
import com.example.customer.manager.CustomerManager;
import com.example.customer.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/api")
public class CustomerAdminController {

    @Autowired
    private CustomerManager customerManager;

    @RequestMapping("/hello")
    public String hello(){
        return "Hello world";
    }

    @RequestMapping(value = "/allcustomers", produces = {"application/json",
                                                         "application/xml"})
    public ResponseEntity<CustomerList> allCustomers() {
        List<Customer> cutomers = customerManager.getAllCustomers();
        CustomerList customerList = new CustomerList(cutomers);
        return ResponseEntity.ok(customerList);
    }

    @RequestMapping(value = "/createCustomer", method = RequestMethod.POST)
    public ResponseEntity<?> createCustomer(@RequestBody Customer customer) {
        if (customer == null) {
            return ResponseEntity.badRequest()
                                 .body(ErrorResponse.createErrorResponse(10,
                                                                         "Customer objesi null olamaz"));
        }
        if (customer.getAge() < 10 || customer.getAge() > 120) {
            return ResponseEntity.badRequest()
                                 .body(ErrorResponse.createErrorResponse(12,
                                                                         "Customer age 10 ile 120 arasında olmalı"));

        }
        if (customer.getCustomerCredential() == null) {
            return ResponseEntity.badRequest()
                                 .body(ErrorResponse.createErrorResponse(13,
                                                                         "Lütfen customer credential larını giriniz"));

        }
        if (customer.getCustomerCredential()
                    .getRoles() == null) {
            return ResponseEntity.badRequest()
                                 .body(ErrorResponse.createErrorResponse(14,
                                                                         "Lütfen customer role lerini giriniz"));

        }

        List<Role> roles = customer.getCustomerCredential()
                                   .getRoles();

        List<Role> allRoles = customerManager.getAllRoles();

        first:
        for (Role role : roles) {
            if (allRoles != null) {
                for (Role exitsRole : allRoles) {
                    if (exitsRole.getRid() == role.getRid()){
                        if (role.equals(exitsRole)) {
                            continue first;
                        } else {
                            return ResponseEntity.badRequest()
                                                 .body(ErrorResponse.createErrorResponse(15,
                                                                                         "Role id başka bir role e ait"));
                        }
                    }
                }
            }
            customerManager.createRole(role);
        }

        boolean result = customerManager.createCustomer(customer);
        return ResponseEntity.ok(result);
    }


    @RequestMapping(value = "/createRole", method = RequestMethod.POST)
    public ResponseEntity<?> createCustomer(Role role) {
        if (role == null) {
            return ResponseEntity.badRequest()
                                 .body(ErrorResponse.createErrorResponse(10,
                                                                         "Role objesi null olamaz"));
        }
        if (role.getRole() == null || role.getRole()
                                          .isEmpty()) {
            return ResponseEntity.badRequest()
                                 .body(ErrorResponse.createErrorResponse(12,
                                                                         "Role ismi boş olamaz"));

        }
        boolean result = customerManager.createRole(role);
        return ResponseEntity.ok(result);
    }


    @RequestMapping("/getCustomerByName/{name}")
    public ResponseEntity<?> getCustomersByName(@PathVariable("name") String name) {
        List<Customer> customerByName = customerManager.getCustomerByName(name);
        if (customerByName == null || customerByName.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                                 .body(ErrorResponse.createErrorResponse(1,
                                                                         "Böyle bir kullanıcı adı yok"));
        }

        return ResponseEntity.ok(customerByName);

    }
}
