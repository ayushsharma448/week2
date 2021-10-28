package com.example5.demo5.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example5.demo5.Entity.Customer;


public interface CustomerRepository extends CrudRepository<Customer, Long> {
	List<Customer> findByAge(int age);
	
    @Query("SELECT p FROM Customer p WHERE LOWER(p.name) = LOWER(:name)")
    public List<Customer> findXyz(@Param("name") String name);
}
