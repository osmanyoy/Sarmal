package com.example.customer.dao;

import com.example.customer.model.Customer;
import com.example.customer.model.CustomerCredential;

import java.util.List;

public abstract class AbstractCustomerDAO implements ICutomerDAO{

    @Override
    public List<Customer> getCustomerByName(String name){
        return null;
    }

    @Override
    public CustomerCredential getCustomerCredential(String s){
        return null;
    }
}
