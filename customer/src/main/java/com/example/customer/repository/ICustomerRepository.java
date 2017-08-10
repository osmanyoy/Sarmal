package com.example.customer.repository;

import com.example.customer.model.Customer;
import com.example.customer.model.CustomerCredential;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICustomerRepository extends CrudRepository<Customer,Long>{
    List<Customer> findAllByName(String name);

    @Query("select c from Customer c inner join c.customerCredential cc where cc.username= :un")
    Customer getCustomerCredential(@Param("un") String username);

    @Query("select cc from Customer c inner join c.customerCredential cc where cc.username= :un")
    CustomerCredential getCustomerCredentialEx(@Param("un") String username);
}


