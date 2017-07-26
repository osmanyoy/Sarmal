package com.training.spring.customer;

import java.util.List;

/**
 * Created by Osman on 25.07.2017.
 */
public interface ICustomerDAO {
    List<Customer> getAllCustomers();

    void createCustomer(Customer customer);
}
