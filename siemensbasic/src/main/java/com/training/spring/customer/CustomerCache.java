package com.training.spring.customer;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.*;

public class CustomerCache {

    private Map<Long,Customer> customerCacheMap = new HashMap<>();

    @Autowired
    private ICustomerDAO customerDAO;

    @PostConstruct
    public void init(){
        List<Customer> allCustomers = customerDAO.getAllCustomers();
        for (Customer customer: allCustomers
             ) {
            customerCacheMap.put(customer.getId(),customer);
        }
    }

    public Customer getCustomerById(long id){
        return customerCacheMap.get(id);
    }

    public Collection<Customer> getAllCustomer(){
        return customerCacheMap.values();
    }


}
