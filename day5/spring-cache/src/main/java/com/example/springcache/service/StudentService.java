package com.example.springcache.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.springcache.domain.Student;


@Service
public class StudentService {
	
private static List<Student> stds;
	
	static{
		stds = getDummyRecords();
	}
	@Cacheable("student")
	public Student getStudentByID(String id) {
		try {
			Thread.sleep(1000*5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Student(id,"Sajal id="+id ," V");
		
	}
	
	@Cacheable("student")
	public List<Student> getStudentList()
	{		
		return  stds;
	}
	
	private static List<Student> getDummyRecords(){
		List<Student> students = new ArrayList<Student>();
		students.add(new Student("1","ramesh","1st"));
		students.add(new Student("2","ayush","2nd"));
		students.add(new Student("3","hitesh","3rd"));
		return students;
	}
	
	@CacheEvict(value = "stds", allEntries = true)
	public void refreshAllStudents() {
		//This method will remove all 'products' from cache, say as a result of flush API.
	}
	@CachePut(value = "stds",key = "#student.name" , unless="#result==null")
	public Student updateStudent(Student student) {
		//logger.info("<!----------Entering updateProduct ------------------->");
		System.out.println("entering update");
		for(Student p : stds){
			if(p.getName().equalsIgnoreCase(student.getName()))
			{
				System.out.println("previously data--"+p);
				p.setClz(student.getClz());
				System.out.println("newly updated one-"+p);
				return p;
			}	
		}
		return null;
	}
	
	@Cacheable(value="stds", key="#name",unless="#result==null")
	public Student getByName(String name) {
		System.out.println("calling name without cache");
		for(Student p : stds){
			if(p.getName().equalsIgnoreCase(name))
				return p;
		}
		return null;
	}
}
