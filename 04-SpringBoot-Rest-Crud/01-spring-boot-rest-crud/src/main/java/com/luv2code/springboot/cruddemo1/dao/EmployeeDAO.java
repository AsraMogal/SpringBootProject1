package com.luv2code.springboot.cruddemo1.dao;

import java.util.List;

import com.luv2code.springboot.cruddemo1.entity.Employee;

public interface EmployeeDAO {

	List<Employee> findAll();
}
