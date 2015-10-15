package com.example;

/**
 * Created by kohpai on 10/16/15.
 */

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String>{
    public List<Customer> findByFirstName(String firstName);
    public List<Customer> findByLastName(String lastName);
}
