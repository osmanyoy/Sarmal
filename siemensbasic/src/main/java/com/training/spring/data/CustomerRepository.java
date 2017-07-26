package com.training.spring.data;

import com.training.spring.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Repository;
import org.springframework.util.concurrent.ListenableFuture;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@Repository
@EnableAsync
public interface CustomerRepository extends JpaRepository<Customer,Long>{

    @Async
    Future<List<Customer>> findByName(String name);

    @Async
    ListenableFuture<List<Customer>> findAllByName(String name);

    @Async
    CompletableFuture<List<Customer>> getAllByName(String name);


    List<Customer> findByNameAndAgeIsGreaterThan(String name,int age);
    List<Customer> findBySurname(String surname);

    @Query("select c from Customer c where c.age = :age and c.name= :name")
    List<Customer> myCustomQuery(@Param("age") int age,@Param("name") String name);


    @Query("select c from Customer c where c.age = ?1 and c.name= ?2")
    List<Customer> myCustomQuery2(int age,String name);


    @Query(value = " select * from customer_table where age = ?1 and customer_name= ?2",nativeQuery = true)
    List<Customer> myCustomQuery3(int age,String name);

    List<Customer> testMyQuery(int age,String name);



}
