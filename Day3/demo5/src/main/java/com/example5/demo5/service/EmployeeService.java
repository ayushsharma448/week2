package com.example5.demo5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example5.demo5.Entity.Employee;
import com.example5.demo5.repository.EmployeeRepo;



@Service
public class EmployeeService implements EmployeeInt {

	@Autowired
	EmployeeRepo empRepo;
	@Override
	public Employee createUser(Employee emp) {
		System.out.println("---------one to one call start");
		System.out.println("emp addr:"+emp.getAddress().getCity()+emp.getAddress().getStreet());
		empRepo.save(emp);
		return emp;
	}

	@Override
	public List<Employee> getUser() {
		List<Employee> le=empRepo.findAbc(1);
		le.forEach(emp ->{System.out.println(emp);});
		
		System.out.println("---------------findXyz() below---------------");
		List<Employee> lo = empRepo.findXyz();
		lo.forEach(emp ->{System.out.println(emp);});
		empRepo.addSalutationToName("Mr.");
		//-------findByNameAndSalary
		return  (List<Employee>)empRepo.findAll();
	}

	@Override
	public Employee findById(long id) {
		// TODO Auto-generated method stub
		return empRepo.findById(id).get();
	}

		
	  @Override public List<Employee> findByNameAndSalary(String name, float salary) 
	  { // TODO Auto-generated method stub return
	  
			  return (List<Employee>)empRepo.findByNameAndSalary(name,salary);
	  }
	  
	  @Override public List<Employee> findByNameAndSalaryGreaterThan(String name, float salary) 
	  { // TODO Auto-generated method stub return
	  
			  return (List<Employee>)empRepo.findByNameAndSalaryGreaterThan(name,salary);
	  }
		
		  public void addSalutation() { // TODO Auto-generated method stub
		  empRepo.addSalutationToName("Mr."); return; }
		 
		

}
