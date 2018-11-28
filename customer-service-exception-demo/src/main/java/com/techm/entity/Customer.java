package com.techm.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;



@Entity
public class Customer implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String email;
	
	@Size(min=2, message="firstName should have atleast 2 characters")
	private String firstName;
	
	@Size(min=4, message="lastName should have atleast 4 characters")
	private String lastName;
	
	@Past(message="Birthdate should be less that current date")
	private Date birthDate;
	
	public Customer() {}
	public Customer(Customer c) {
		this.setEmail(c.getEmail());
		this.setFirstName(c.getFirstName());
		this.setLastName(c.getLastName());
		this.setBirthDate(c.getBirthDate());
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	
}
