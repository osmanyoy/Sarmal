package com.training.spring.data;

import com.training.spring.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long>{
    List<Customer> findByName(String name);
    List<Customer> findByNameAndAgeIsGreaterThan(String name,int age);

}
