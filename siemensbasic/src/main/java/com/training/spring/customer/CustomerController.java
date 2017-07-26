package com.training.spring.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    @Autowired
    private CustomerManager customerManager;

    @RequestMapping(path = "/customer/{id}", produces = {"application/json",
                                                         "application/xml"})
    public Customer getCustomer(@PathVariable("id") long id) {
        return customerManager.getCustomerById(id);
    }

    @RequestMapping(path = "/allcustomers", produces = {"application/json",
                                                        "application/xml"})
    public Customers getAllCustomers(@RequestParam("count") int count) {
        Customers customers = new Customers();
        customers.setCustomers(customerManager.getAllCustomer());
        return customers;

    }

    @RequestMapping(method = RequestMethod.PUT, path = "/createCustomer", produces = {"application/json",
                                                                                      "application/xml"}, consumes = {"application/json",
                                                                                                                      "application/xml"})
    public boolean createCustomer(@RequestBody Customer customer) {
        customerManager.createCustomer(customer);
        return true;
    }

}
