package com.luv2code.cruddemo.DAO;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;

@Repository //helps in component scanning and is applied to Dao Implementation.It is a sub annotation of @component
public class StudentDAOImpl implements StudentDao{

	//define entity manager field
	private EntityManager entityManager;
	
	//inject entity manager using constructor injection
	public StudentDAOImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	//save the student
	@Override
	@Transactional
	public void save(Student student) {
		entityManager.persist(student);
		
	}


}
