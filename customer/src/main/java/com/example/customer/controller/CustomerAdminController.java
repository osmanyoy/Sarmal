package com.example.customer.controller;

import com.example.customer.Customer;
import com.example.customer.CustomerList;
import com.example.customer.manager.CustomerManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerAdminController {

    @Autowired
    private CustomerManager customerManager;

    @RequestMapping(value = "/allcustomers",produces = {"application/json","application/xml"})
    public ResponseEntity<CustomerList> allCustomers(){
        List<Customer> cutomers = customerManager.getAllCustomers();
        CustomerList customerList = new CustomerList(cutomers);
        return ResponseEntity.ok(customerList);
    }
}
