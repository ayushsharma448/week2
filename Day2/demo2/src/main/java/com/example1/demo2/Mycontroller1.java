package com.example1.demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Mycontroller1 {

	@Autowired
	DemoComponent dc;
	
	
	  @GetMapping("/") String metAssignment() { return dc.display();
	  
	  }
	 
}