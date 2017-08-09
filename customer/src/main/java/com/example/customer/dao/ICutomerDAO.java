package com.example.customer.dao;

import com.example.customer.Customer;

import java.util.List;

public interface ICutomerDAO {
    public List<Customer> getAllCustomers();

    boolean createCustomer(Customer customer);

    List<Customer> getCustomerByName(String name);
}
