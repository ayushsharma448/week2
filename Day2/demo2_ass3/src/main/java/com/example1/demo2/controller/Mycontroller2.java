package com.example1.demo2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example1.demo2.DemoComponent;
import com.example1.demo2.Employee;
import com.example1.demo2.Service.EmployeeService;

@RestController
@RequestMapping("/em")
public class Mycontroller2 {

	@Autowired
	EmployeeService empservice;
	
	@Autowired
	DemoComponent dc;
	
	@GetMapping("/met")
	List<Employee> getEmployees()
	{
		
		return empservice.getAllEmployees();
	}
	
	@PostMapping("/create")
	Employee createEmployee(@RequestBody Employee ecreate)
	{		
		return empservice.createEmployee(ecreate);
		
	}
	
	@GetMapping("/employee")
	Employee getEmployee(@RequestParam("eid") Integer eid)
	{		
		return empservice.getEmployee(eid);
		
	}
}