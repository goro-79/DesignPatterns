package com.grsdev.design.patterns.chap01.strategey.pack03;

import java.io.Serializable;

public class Employee implements Serializable{
	
	private static final long serialVersionUID = 123129L;

	private long id;
	
	private String firstName,lastName;
	
	private String city;

	public Employee(long l, String string, String string2, String string3) {
		this.id=l;
		this.firstName=string;
		this.lastName=string2;
		this.city=string3;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", city=" + city + "]";
	}
	
	
}
