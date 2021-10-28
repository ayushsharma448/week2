package com.example5.demo5.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="empinfo11")
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	@Column(name="eid")
	private long id;
	
	@NotNull(message="Name cannot be null")
	@Column(name="ename")
	private String name;
	
	@Column(name="esalary")
	private float salary;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="address_id",referencedColumnName="id")
	private Address address;
	
	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public Employee(long id, float salary, String name) {
		super();
		this.id = id;
		this.salary = salary;
		this.name = name;
	}
	
	
	public Employee() {
		super();
	}


	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", salary=" + salary + ", name=" + name + "]";
	}
	
	
}
