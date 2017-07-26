package com.training.spring.customer;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Osman on 25.07.2017.
 */
public class CustomerManager {

    @Autowired
    private CustomerCache customerCache;

    @Autowired
    private ICustomerDAO customerDAO;

    public Customer getCustomerById(long id ){
        return customerCache.getCustomerById(id);
    }
    public List<Customer> getAllCustomer(){
        return new ArrayList<>(customerCache.getAllCustomer());
    }

    public void createCustomer(Customer customer) {
        customerDAO.createCustomer(customer);
    }
}
