package com.luv2code.springboot.cruddemo1.dao;

import java.util.List;

import com.luv2code.springboot.cruddemo1.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class EmployeeDAOImpl implements EmployeeDAO {

	//define filed for entity manager
	private EntityManager entityManager;
	
	//set up constructor injection
	public EmployeeDAOImpl(EntityManager theentitymanager)
	{
		entityManager = theentitymanager;
	}
	
	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		//create query
		TypedQuery<Employee> theQuery = entityManager.createQuery("from employee",Employee.class);
		 List<Employee> employess = theQuery.getResultList();
		//execute query
		return employess;
	}

}
