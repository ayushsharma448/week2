package com.example5.demo5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example5.demo5.Entity.Customer;
import com.example5.demo5.repository.CustomerRepository;


@Service
public class CustomerService0 {
@Autowired
CustomerRepository repository;

	//Basic Transaction Example
	@Transactional
	public Customer internalMethod(Customer customer) 
	{
		Customer _customer = repository.save(new Customer(customer.getName(), customer.getAge()));

		int age=_customer.getAge();
		if(age==32)
		throw new RuntimeException("aaaaaa");
	
		//NOTE: When above line uncommented record is not inserted 
		//as Exception occurs and record saved gets rolled back
		return _customer;
	}

}
