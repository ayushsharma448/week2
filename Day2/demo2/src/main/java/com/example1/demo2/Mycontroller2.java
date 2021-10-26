package com.example1.demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Mycontroller2 {

	@Autowired
	DemoComponent dc;
	
	@GetMapping("/met")
	Employee met()
	{
		Employee emp= new Employee(10,"dsdkfhkh");
		//return dc.display();
		return emp;
	}
}