package com.example5.demo5.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="Address")
public class Address {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Column(name="street")
	private String street;
	
	@Column(name="city")
	private String city;

	
	
	public long getId() {
		return id;
	}

	public Address()
	{
		super();
	}
	public Address(long id, String street, String city) {
		super();
		this.id = id;
		this.street = street;
		this.city = city;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {	
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}
