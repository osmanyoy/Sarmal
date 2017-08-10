package com.example.customer.dao;

import com.example.customer.model.Customer;

import java.util.List;

public abstract class AbstractCustomerDAO implements ICutomerDAO{

    @Override
    public List<Customer> getCustomerByName(String name){
        return null;
    }
}
