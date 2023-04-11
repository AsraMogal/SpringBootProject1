package com.luv2code.springboot.cruddemo1.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.cruddemo1.dao.EmployeeDAO;
import com.luv2code.springboot.cruddemo1.entity.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	//inject EmployeeDao
	private EmployeeDAO employeeDao;
	
	//constructor Injection
	public EmployeeRestController(EmployeeDAO theemployeeDao)
	{
		employeeDao = theemployeeDao;
	}
	//expose /employees and return a list of students
	@GetMapping("/employees")
	public List<Employee> findAllEmployees()
	{
		System.out.println("Hello World");
		return employeeDao.findAll();
	}
}

