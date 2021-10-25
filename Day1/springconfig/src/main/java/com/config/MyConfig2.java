package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.logic.A;

public class MyConfig2 {
	@Lazy
	@Bean 
	@Scope("prototype")
	public A getA(int p1){
		return new A(p1);
	}
}
