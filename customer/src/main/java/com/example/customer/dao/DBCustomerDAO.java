package com.example.customer.dao;


import com.example.customer.model.Customer;
import com.example.customer.model.CustomerCredential;
import com.example.customer.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class DBCustomerDAO extends AbstractCustomerDAO{

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

    @Override
    public boolean createCustomer(Customer customer) {
        Customer save = customerRepository.save(customer);
        if (save != null){
            return true;
        }
        return false;
    }

    @Override
    public List<Customer> getCustomerByName(String name) {
        return customerRepository.findAllByName(name);
    }

    @Override
    public CustomerCredential getCustomerCredential(String s) {
        CustomerCredential customerCredentialEx = customerRepository.getCustomerCredentialEx(s);
        Customer customer = customerRepository.getCustomerCredential(s);
        if (customer != null){
            return customer.getCustomerCredential();
        }
        return  null;
    }
}
