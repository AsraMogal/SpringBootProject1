package com.luv2code.springboot.thymeleafdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	// load employee data

	private List<Employee> theEmployees;
	
	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeController(EmployeeService theEmployeeService)
	{
		employeeService = theEmployeeService;
	}

	/*
	 * @PostConstruct private void loadData() {
	 * 
	 * // create employees Employee emp1 = new Employee("Leslie", "Andrews",
	 * "leslie@luv2code.com"); Employee emp2 = new Employee("Emma", "Baumgarten",
	 * "emma@luv2code.com"); Employee emp3 = new Employee("Avani", "Gupta",
	 * "avani@luv2code.com");
	 * 
	 * // create the list theEmployees = new ArrayList<>();
	 * 
	 * // add to the list theEmployees.add(emp1); theEmployees.add(emp2);
	 * theEmployees.add(emp3); }
	 */
	// add mapping for "/list"

	@GetMapping("/list")
	public String listEmployees(Model theModel) {

		//retrive  the employee list from DB
		theEmployees  = employeeService.findAll();
		// add to the spring model
		theModel.addAttribute("employees", theEmployees);

		return "employees/list-employees";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormforAdd(Model theModel)
	{
		//Create a model attribute - responsible for binding the form data This on form loading calls get method and upon submit calls 
		//setter methods
		Employee theEmployee = new Employee();
		
		theModel.addAttribute("employee",theEmployee);
		
		return "employees/employee-form";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee)
	{
		//Save the employee object you got from form data 
		employeeService.save(theEmployee);
		
		//return to list page to avoid duplicate submission
		return "redirect:/employees/list";
	}
	
}









