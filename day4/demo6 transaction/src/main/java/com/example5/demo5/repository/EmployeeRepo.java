package com.example5.demo5.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example5.demo5.Entity.Employee;

@Repository
public interface EmployeeRepo extends PagingAndSortingRepository<Employee, Long>
{
	
	//ASSIGNMENT 1
	List<Employee> findByNameAndSalary(String name, float salary);
	List<Employee> findByNameAndSalaryGreaterThan(String name, float salary);
	//CustomQuery (JPQL Query using Named parameter)
		@Query("SELECT e FROM Employee e WHERE e.salary > :sal") //Named parameter
		List<Employee> findAbc(@Param("sal") float salary);
		
		///ASSIGNEMNT 2
		//@Query(value="select E.id, E.name, E.salary from Empinfo1 E", nativeQuery=true)
		@Query(value="select E.eid, E.ename, E.esalary from Empinfo11 E where E.esalary>100 and E.esalary<10000", nativeQuery=true)
		List<Employee> findXyz();
		
		
		  @Transactional
		  
		  @Query("Update Employee SET name = :salutation || name")
		  
		  @Modifying void addSalutationToName(@Param("salutation") String salutation);
		 
}
