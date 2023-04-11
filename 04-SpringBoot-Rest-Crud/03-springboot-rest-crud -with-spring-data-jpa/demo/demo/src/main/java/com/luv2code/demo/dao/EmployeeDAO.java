package com.luv2code.demo.dao;

import java.util.List;

import com.luv2code.demo.Entity.Employee;

public interface EmployeeDAO {

	//return list of employees
	public List<Employee> findAllEmployees();
	
	//find Employee by Id
	Employee findById(int theId);
	
	//save an Employee
	Employee saveEmployee(Employee theEmployee);
	
	//Delete Employee by ID
	void delete(int theId);
}
