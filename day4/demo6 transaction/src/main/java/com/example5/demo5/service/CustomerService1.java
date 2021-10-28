package com.example5.demo5.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example5.demo5.Entity.Customer;
import com.example5.demo5.repository.CustomerRepository;


@Service
public class CustomerService1 {
	
	@Autowired
	CustomerService2 service2;
	
	@Autowired
	CustomerRepository repository;
	
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
	public Customer internalMethod(Customer customer)
	{
		Customer _customer = repository.save(new Customer(customer.getName()+"first", customer.getAge()));
		//not commited  --- outer
		
		service2.internalMethod1(_customer);
		//commited
		
		//if propogation is required and any exception occurs in outer then no data will get committed.....
		/*
		 * if(true) { //thorw exception so that book will not save in DB throw new
		 * RuntimeException("this exception in throwing intentionally when first one check is true"
		 * ); }
		 */
		if(false)
		{ 
			  throw new RuntimeException("this exception in throwing intentionally when first one check is true"); 
		 }
		return _customer;
	}

}
