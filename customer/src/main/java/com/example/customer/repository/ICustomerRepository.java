package com.example.customer.repository;

import com.example.customer.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICustomerRepository extends CrudRepository<Customer,Long>{
    List<Customer> findAllByName(String name);
}
