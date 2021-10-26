package com.example1.demo2.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example1.demo2.Employee;
import com.example1.demo2.repository.EmployeeRepo;

@Service
public class EmployeeServiceImp implements EmployeeService {

	@Autowired
	EmployeeRepo erepo;
	
	public Employee createEmployee(Employee emp)
	{
		erepo.addEmployee(emp);
		return emp;
	}
	
	public List<Employee> getAllEmployees()
	{
		return erepo.getEmployees();
	}

	@Override
	public Employee getEmployee(int empId) {
		return erepo.getEmployee(empId);
		
	}

	@Override
	public Employee modifyEmployee(int empid, Employee emp) {
		return erepo.updateEmployee(empid, emp);
	}
}
