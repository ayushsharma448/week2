package com.example1.demo2.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example1.demo2.Employee;

@Service
public interface EmployeeService {

	Employee createEmployee(Employee emp);
	List<Employee> getAllEmployees();
	Employee getEmployee(int empId);
}
