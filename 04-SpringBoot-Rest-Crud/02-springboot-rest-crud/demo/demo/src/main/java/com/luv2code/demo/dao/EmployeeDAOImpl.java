package com.luv2code.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.demo.Entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	//DAO needs Entity Manager , so inject Entity Manager
	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOImpl(EntityManager theEntityManager)
	{
		entityManager=theEntityManager;
	}
	@Override
	public List<Employee> findAllEmployees() {
		
		//define Query
		TypedQuery<Employee> theQuery = entityManager.createQuery("From Employee", Employee.class);
		
		//execute Query
		List<Employee> employees = theQuery.getResultList();
		
		//return the result
		return employees;
	}

}
