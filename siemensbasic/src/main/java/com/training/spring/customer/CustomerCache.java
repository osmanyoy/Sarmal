package com.training.spring.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;

import javax.annotation.PostConstruct;
import java.util.*;

public class CustomerCache {

    private Map<Long,Customer> customerCacheMap ;

    @Autowired
    private ICustomerDAO customerDAO;

    @PostConstruct
    public void init(){
        customerCacheMap = refreshAllCustomer();
    }

    private Map<Long,Customer> refreshAllCustomer(){
        Map<Long,Customer> customerCacheMapTemp = new HashMap<>();
        List<Customer> allCustomers = customerDAO.getAllCustomers();
        for (Customer customer: allCustomers
                ) {
            customerCacheMapTemp.put(customer.getId(),customer);
        }
        return customerCacheMapTemp;
    }

    public Customer getCustomerById(long id){
        return customerCacheMap.get(id);
    }

    public Collection<Customer> getAllCustomer(){
        return customerCacheMap.values();
    }


    @Scheduled(fixedDelay = 10_000)
    public void refresh(){
        customerCacheMap = refreshAllCustomer();

    }

}
