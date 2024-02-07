package com.amigoscode;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findCustomerByAgeAfter(Integer age);

    Customer getCustomerById(Integer id);
}


