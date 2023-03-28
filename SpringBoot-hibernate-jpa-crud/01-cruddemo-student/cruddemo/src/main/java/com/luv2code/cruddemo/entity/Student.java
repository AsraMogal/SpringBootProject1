package com.luv2code.cruddemo.entity;

import jakarta.persistence.*;
@Entity
@Table(name = "student")
public class Student {

	//define columns
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastname;
	
	@Column(name="email")
	private String email;

	//define no param constructor
	public Student()
	{
		
	}
	//define paramaterized constructor
	
	public Student( String firstName, String lastname, String email) {
		super();
		this.firstName = firstName;
		this.lastname = lastname;
		this.email = email;
	}

	//define getters and setters
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	//define toString
	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastname=" + lastname + ", email=" + email + "]";
	}
	
	
}
