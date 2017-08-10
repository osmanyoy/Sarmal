package com.example.customer.manager;

import com.example.customer.model.Customer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Osman on 8.08.2017.
 */
public class CustomerCache {
    private Map<Long, Customer> customerMap = new HashMap<>();

    public void refreshMap(List<Customer> customerList) {
        Map<Long, Customer> tempCustomerMap = new HashMap<>();
        for (Customer customer : customerList) {
            tempCustomerMap.put(customer.getId(),
                                customer);
        }
        customerMap = tempCustomerMap;
    }
}
