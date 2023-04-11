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
	
	//Find Emloyee By id
	@Override
	public Employee findById(int theId) {
		
		//Find the Employee by ID
		
		Employee theEmployee = entityManager.find(Employee.class, theId);
		
		return theEmployee;
	}
	
	//save or update Employee .Here we are not using @transactional 
	//even though it modifies the DB as it will be mentioned in Service Layer
	@Override
	public Employee saveEmployee(Employee theEmployee) {
		//save or Update using Merge method of entity Manager
		//If the id==0 then the record will be saved or inserted else it will be update if its an existing id
		//return the new object because in case of insert the up will be updated in database
		Employee dbEmployee = entityManager.merge(theEmployee);
		return dbEmployee;
	}
	
	//delete an employee based on id
	//	Here we are not using @transactional 
	//even though it modifies the DB as it will be mentioned in Service Layer
	@Override
	public void delete(int theId) {
		Employee employee = entityManager.find(Employee.class, theId);
		entityManager.remove(employee);
	}

}
