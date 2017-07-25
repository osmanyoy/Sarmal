package com.training.spring.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    private CustomerManager customerManager;

    @RequestMapping(path = "/customer/{id}",produces = {"application/json",
                                                 "application/xml"})
    public Customer getCustomer(@PathVariable("id") long id) {
        return customerManager.getCustomerById(id);
    }

    @RequestMapping(path = "/allcustomers",produces = {"application/json",
                                                       "application/xml"})
    public Customers getAllCustomers(@RequestParam("count") int count) {
        Customers customers = new Customers();
        customers.setCustomers(customerManager.getAllCustomer());
        return customers;

    }

}
