package com.example5.demo5.service;

import java.util.List;

import com.example5.demo5.Entity.Employee;



public interface EmployeeInt {
	public Employee createUser(Employee emp);
	public List<Employee> getUser();
	public Employee findById(long id);
	public List<Employee> findByNameAndSalary(String namecontains, float salary);
	public List<Employee> findByNameAndSalaryGreaterThan(String name, float salary);
	public void addSalutation();
	
}
