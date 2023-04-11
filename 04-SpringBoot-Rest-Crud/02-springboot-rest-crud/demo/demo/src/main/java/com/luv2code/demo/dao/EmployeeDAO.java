package com.luv2code.demo.dao;

import java.util.List;

import com.luv2code.demo.Entity.Employee;

public interface EmployeeDAO {

	public List<Employee> findAllEmployees();
}
