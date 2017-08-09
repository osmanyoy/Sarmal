package com.example.customer.dao;


import com.example.customer.Customer;
import com.example.customer.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class DBCustomerDAO implements ICutomerDAO{

    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomers() {
        Iterable<Customer> customers = customerRepository.findAll();
        List<Customer> customerList = new ArrayList<>();
        for (Customer customer:customers) {
            customerList.add(customer);
        }
        return customerList;
    }
}
