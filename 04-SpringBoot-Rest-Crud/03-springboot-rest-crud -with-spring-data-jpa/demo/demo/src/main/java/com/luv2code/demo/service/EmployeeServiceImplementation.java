package com.luv2code.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.demo.Entity.Employee;
import com.luv2code.demo.dao.EmployeeDAO;

import jakarta.transaction.Transactional;

@Service // this acts as a service call that talks to DAO.We need to inject DAO here
public class EmployeeServiceImplementation implements EmployeeService{

	private EmployeeDAO employeeDao;
	
	//Constructor Injection of EmployeeDAO
	@Autowired
	public EmployeeServiceImplementation(EmployeeDAO theEmployeeDao)
	{
		employeeDao = theEmployeeDao;
	}
	
	@Override
	public List<Employee> findAll() {
		return employeeDao.findAllEmployees();
	}

	@Transactional // transaction here in service class because we didnt mention in DAO and it modifies the DB
	@Override
	public Employee findById(int theId) {
		// TODO Auto-generated method stub
		return employeeDao.findById(theId);
	}

	@Transactional // transaction here in service class because we didnt mention in DAO and it modifies the DB
	@Override
	public Employee saveEmployee(Employee theEmployee) {
		// TODO Auto-generated method stub
		return employeeDao.saveEmployee(theEmployee);
	}
	
	@Transactional // transaction here in service class because we didnt mention in DAO and it modifies the DB
	@Override
	public void delete(int theId) {
		// TODO Auto-generated method stub
		employeeDao.delete(theId);
		
	}

}
