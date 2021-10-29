package com.example.springcache.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.springcache.domain.Student;
import com.example.springcache.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@GetMapping("/student/{id}")
	public Student findStudentById(@PathVariable String id) {
		System.out.println("Searching by ID  : " + id);
		
		System.out.println(studentService.getByName("ramesh"));
		System.out.println(studentService.getByName("ayush"));
		
		Student st = new Student("1","ramesh","2nd");		
		
		Student p=studentService.updateStudent(st);
		System.out.println(studentService.getByName("ramesh"));
		System.out.println(studentService.getByName("ayush"));
		
		
		//System.out.println(studentService.getStudentByID(id));
		studentService.refreshAllStudents();
		
		System.out.println("-------after refreshed-----");
		System.out.println(studentService.getByName("ramesh"));
		System.out.println(studentService.getByName("ayush"));
		
		return p;
	}
	
	
}
