package com.example5.demo5.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example5.demo5.Entity.Employee;
import com.example5.demo5.service.EmployeeInt;

@RestController
public class Demo5Controller {

	@Autowired
	EmployeeInt empInt;
	
	

	@PostMapping("/create")
	Employee createEmployee(@Valid @RequestBody Employee ecreate)
	{		
		return empInt.createUser(ecreate);		
	}
	
	@GetMapping("/met")
	List<Employee> getEmployees()
	{
		
		return empInt.getUser();
	}
	
	@GetMapping(value="/getnamesalary/{name}/{salary}", headers="Accept=application/json")
	 public List<Employee> getnamesalary(@PathVariable String name, @PathVariable float salary) {	 
	  List<Employee> tasks=empInt.findByNameAndSalary(name, salary);
	  return tasks;	
	 }
	
	@GetMapping(value="/getnamesalaryGreaterThan/{name}/{salary}", headers="Accept=application/json")
	 public List<Employee> getnamesalaryGreaterThan(@PathVariable String name, @PathVariable float salary) {	 
	  List<Employee> tasks=empInt.findByNameAndSalaryGreaterThan(name, salary);
	  return tasks;	
	 }
}
