package com.example.customer.controller;

import com.example.customer.Customer;
import com.example.customer.CustomerList;
import com.example.customer.manager.CustomerManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerAdminController {

    @Autowired
    private CustomerManager customerManager;

    @RequestMapping(value = "/allcustomers", produces = {"application/json",
                                                         "application/xml"})
    public ResponseEntity<CustomerList> allCustomers() {
        List<Customer> cutomers = customerManager.getAllCustomers();
        CustomerList customerList = new CustomerList(cutomers);
        return ResponseEntity.ok(customerList);
    }

    @RequestMapping(value = "/createCustomer", method = RequestMethod.POST)
    public ResponseEntity<?> createCustomer(Customer customer) {
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
        boolean result = customerManager.createCustomer(customer);
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
