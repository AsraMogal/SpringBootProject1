package com.luv2code.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.demo.Entity.Employee;
import com.luv2code.demo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	//add hello endpoint
	
	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeRestController(EmployeeService theemployeeService)
	{
		employeeService = theemployeeService;
	}
	
	//mapping to get all the employees
	@GetMapping("/employees")
	public List<Employee> findAll()
	{
		return employeeService.findAll();
	}
	
	//add mapping for GET /employee/{employeeId}
	@GetMapping("/employee/{employeeId}") 
	public Employee getEmployee(@PathVariable int employeeId) {
		Employee theEmployee = employeeService.findById(employeeId);
		
		if(theEmployee == null)
		{
			throw new RuntimeException("EmployeeId not Found - "+employeeId);
		}
		return theEmployee;
	}
	
	//Add mapping for post Employee
	@PostMapping("/employee")
	public Employee saveEmployee(@RequestBody Employee employee)
	{
		//set the id to zero so in case if the rest client is passing the id value .we can force it to save a new record
		employee.setId(0);
		Employee dbEmployee = employeeService.saveEmployee(employee);
		return dbEmployee;
	}
	
	//add mapping for /employee to update the employee
	@PutMapping("/employee")
	public Employee updateEmployee(@RequestBody Employee employee)
	{
		Employee dbEmployee = employeeService.saveEmployee(employee);
		return dbEmployee;
	}
	
	@DeleteMapping("/employee/{empId}")
	public String deleteEmployee(@PathVariable int empId)
	{
		Employee employee = employeeService.findById(empId);
		
		if(employee == null)
		{
			throw new RuntimeException("No Employee with id - "+empId);
		}
		
		employeeService.delete(empId);
		
		return "employee with id deleted"+empId;
	}
}
