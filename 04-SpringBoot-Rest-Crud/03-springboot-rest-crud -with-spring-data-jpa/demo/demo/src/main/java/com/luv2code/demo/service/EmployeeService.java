package com.luv2code.demo.service;

import java.util.List;

import com.luv2code.demo.Entity.Employee;

public interface EmployeeService {
	
	List<Employee> findAll();
	
	//find Employee by Id
	Employee findById(int theId);
		
	//save an Employee
	Employee saveEmployee(Employee theEmployee);
		
	//Delete Employee by ID
	void delete(int theId);
}
