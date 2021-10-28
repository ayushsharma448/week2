package com.example5.demo5.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example5.demo5.Entity.Customer;
import com.example5.demo5.repository.CustomerRepository;
import com.example5.demo5.service.CustomerService0;
import com.example5.demo5.service.CustomerService1;



//@CrossOrigin("http://192.168.44.44:4200")
@RestController
@RequestMapping("/api")
public class CustomerController {

	@Autowired
	CustomerRepository repository;
	
	@Autowired
	CustomerService1 service1;

	@Autowired
	CustomerService0 service0;
	
	
	@GetMapping("/customers")
	public List<Customer> getAllCustomers() {
		System.out.println("Get all Customers...");

		List<Customer> customers = new ArrayList<>();
		repository.findAll().forEach(customers::add);

		return customers;
	}

	//to check simple transaction
	@PostMapping(value = "/customers/create")
	public Customer postCustomer(@RequestBody Customer customer){

		Customer ct = service0.internalMethod(customer);
		//Customer ct = internalMethod(customer);
		return ct;
	}

	//to check nested transaction
	@PostMapping(value = "/customers/create1")
	public Customer postCustomer1(@RequestBody Customer customer){

		Customer ct = service1.internalMethod(customer);
		//Customer ct = internalMethod(customer);
		return ct;
	}

		
	
	
	@PutMapping("/customers/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable("id") long id, @RequestBody Customer customer) {
		System.out.println("Update Customer with ID = " + id + "...");

		Optional<Customer> customerData = repository.findById(id);

		if (customerData.isPresent()) {
			Customer _customer = customerData.get();
			_customer.setName(customer.getName());
			_customer.setAge(customer.getAge());
			_customer.setActive(customer.isActive());
			return new ResponseEntity<>(repository.save(_customer), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
