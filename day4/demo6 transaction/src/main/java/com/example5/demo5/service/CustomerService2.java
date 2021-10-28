package com.example5.demo5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example5.demo5.Entity.Customer;
import com.example5.demo5.repository.CustomerRepository;


@Service
public class CustomerService2 {
	@Autowired
	CustomerRepository repository;
	
	
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
	//You may also check behavior with Propogation.REQUIRED, MANDATORY, NOT_SUPPORTED, NEVER
	public Customer internalMethod1(Customer customer)
	{
		Customer _customer = repository.save(new Customer(customer.getName()+"second", customer.getAge()));
		//since new transaction is started, above record gets saved as no exceptions are thrown here
		if(_customer.getAge()==22)
		{ 
			  throw new RuntimeException("this exception in throwing intentionally when second one check is true"); 
		 }
		return _customer;
	}
}
