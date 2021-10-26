package com.example1.demo2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example1.demo2.DemoComponent;

@RestController
public class Mycontroller1 {

	@Autowired
	DemoComponent dc;
	
	
	  @GetMapping("/") String metAssignment() { return dc.display();
	  
	  }
	 
}