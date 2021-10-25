package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import com.logic.Employee;

public class MyConfig1 {
	@Bean 
	@Scope("prototype")
	public Employee getEBean(){
		System.out.println("public Employee getEBean()");
		return new Employee();
	}
}
