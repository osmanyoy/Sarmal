package com.example.demo.security;

import com.example.demo.integration.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Repository
public interface MyPersonRepository extends CrudRepository<Person,Long>{

    // Optional<List<Person>> findAllCustom();

    // Stream<Person> findAllAndStream();

    Optional<Person> findByUsername(String username);
}
