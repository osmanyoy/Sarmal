package com.training.spring.customer;

import com.training.spring.data.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DBCustomerDAO implements ICustomerDAO{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public void createCustomer(Customer customer) {
        customerRepository.save(customer);
    }

}
