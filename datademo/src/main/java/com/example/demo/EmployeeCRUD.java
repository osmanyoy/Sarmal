package com.example.demo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeCRUD extends CrudRepository<Employee,Long> {

    List<Employee> findByName(String name);
    List<Employee> findByAgeGreaterThanAndAgeIsLessThan(int a,int b);

    @Query("select e from Employee e where e.age > :first and e.age < :second")
    List<Employee> alEmployeeleri(@Param("first") int first, @Param("second") int second);

    @Query(value = "select * from employee where age > :first and age < :second",nativeQuery = true)
    List<Employee> alEmployeeleri2(@Param("first") int first, @Param("second") int second);


}
