package com.luv2code.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.demo.Entity.Employee;
import com.luv2code.demo.dao.EmployeeRepository;

@Service // this acts as a service call that talks to DAO.We need to inject DAO here
public class EmployeeServiceImplementation implements EmployeeService{

	private EmployeeRepository employeeRepository;
	
	//Constructor Injection of EmployeeDAO
	@Autowired
	public EmployeeServiceImplementation(EmployeeRepository theEmployeeRepository)
	{
		employeeRepository = theEmployeeRepository;
	}
	
	@Override
	public List<Employee> findAll() {
		//return employeeDao.findAllEmployees();
		return employeeRepository.findAll();
	}

	//@Transactional
	//remove @Transactional too since JpaRepository provides this functionality
	@Override
	public Employee findById(int theId) {
		// TODO Auto-generated method stub
		//return employeeDao.findById(theId);
		Optional<Employee> result = employeeRepository.findById(theId);
		Employee employee = null;
		if(result.isPresent())
		{
			employee = result.get();
		}
		else {
			throw new RuntimeException("Employee with this id not found - "+theId);
		}
		return employee;
	}

	//@Transactional 
	//remove @Transactional too since JpaRepository provides this functionality
	@Override
	public Employee saveEmployee(Employee theEmployee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(theEmployee);
	}
	
	//@Transactional 
	//remove @Transactional too since JpaRepository provides this functionality
	@Override
	public void delete(int theId) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(theId);
		
	}

}
