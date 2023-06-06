package com.luv2code.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.demo.Entity.Employee;

// Previously with JPA we were creating a DAO interface and Implement that DAO
//But suppose if the code needs multiple DAO implementatios then it becomes tedious
//since most of the DAO tasks are similar, There is something called Spring Data JPA which just takes the entity name and primary number
//then all the crud methods are accessible
//we could achieve this by JpaRepository
//Employee is the Entity Type and Integer is the primary key type

public interface EmployeeRepository extends JpaRepository<Employee , Integer>{

	// no need to write any code , all the crud methods are accessible
}
