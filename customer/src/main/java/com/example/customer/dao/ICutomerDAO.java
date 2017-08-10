package com.example.customer.dao;

import com.example.customer.model.Customer;
import com.example.customer.model.CustomerCredential;

import java.util.List;

public interface ICutomerDAO {
    public List<Customer> getAllCustomers();

    boolean createCustomer(Customer customer);

    List<Customer> getCustomerByName(String name);


    CustomerCredential getCustomerCredential(String s);
}
