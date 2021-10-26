package com.example1.demo2.repository;

import java.util.*;

import org.springframework.stereotype.Repository;

import com.example1.demo2.Employee;

@Repository
public class EmployeeRepo {

	private ArrayList<Employee> ale;
	
	EmployeeRepo()
	{
		ale = new ArrayList<Employee>();
	}
	
	public Employee addEmployee(Employee e)
	{		
		ale.add(e);
		
		return e;
	}
	
	public List<Employee> getEmployees()
	{
	 return ale;	
	}
	
	 public Employee getEmployee(int empid)
	 {
		 return ale.get(empid);
	 }
	 
	 public Employee updateEmployee(int empid, Employee emp)
	 {
		  ale.set(empid,emp);
		  return emp;
	 }
}
