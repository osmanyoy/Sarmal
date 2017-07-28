package com.training.spring;

import com.training.spring.customer.Customer;
import com.training.spring.customer.CustomerManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Endpoint
public class WSTest {

    private static final String NAMESPACE_URI = "http://spring.training.com";

    @Autowired
    private CustomerManager customerManager;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCustomerRequest")
    @ResponsePayload
    public Customer getCustomer(@RequestPayload long id) {
        return customerManager.getCustomerById(id);
    }
}
