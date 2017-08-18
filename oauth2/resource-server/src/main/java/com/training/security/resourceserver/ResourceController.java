package com.training.security.resourceserver;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {

    @RequestMapping("/customer")
    public Customer getResource(){
        Customer customer = new Customer();
        customer.setName("osman");
        customer.setSurname("yay");
        customer.setAge(100);
        return customer;
    }
}
