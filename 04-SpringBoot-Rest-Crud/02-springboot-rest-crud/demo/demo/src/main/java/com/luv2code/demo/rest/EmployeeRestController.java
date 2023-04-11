package com.luv2code.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.demo.Entity.Employee;
import com.luv2code.demo.dao.EmployeeDAO;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	//add hello endpoint
	
	private EmployeeDAO theEmployeeDAO;
	
	@Autowired
	public EmployeeRestController(EmployeeDAO employeeDao)
	{
		theEmployeeDAO = employeeDao;
	}
	
	@GetMapping("/employee")
	public List<Employee> findAll()
	{
		return theEmployeeDAO.findAllEmployees();
	}
}
