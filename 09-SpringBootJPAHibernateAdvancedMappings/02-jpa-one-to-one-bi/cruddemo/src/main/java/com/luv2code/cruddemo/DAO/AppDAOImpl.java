package com.luv2code.cruddemo.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.cruddemo.Entity.Instructor;
import com.luv2code.cruddemo.Entity.InstructorDetail;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class AppDAOImpl implements AppDAO{

	//DAO Needs EntityManager
	
	public EntityManager entityManager;
	
	//Constructor Injection of EntityManager
	@Autowired
	public AppDAOImpl(EntityManager entityManager)
	{
		this.entityManager = entityManager;
	}
	
	@Override
	@Transactional
	public void save(Instructor theInstructor) {
		// this will also save the details of InstructorDetail because of cascadetype.ALL
		entityManager.persist(theInstructor);
	}

	//This will retrieve the InstructorDetail object also because the default fetch type of OneToOne is Eager
	@Override
	public Instructor findInstructorById(int id) {
		// TODO Auto-generated method stub
		return  entityManager.find(Instructor.class,id);
	}

	@Override
	@Transactional
	public void deleteinstructorById(int id) {
		// TODO Auto-generated method stub
		
		//Find Instructor By Id
		Instructor theInstructor = entityManager.find(Instructor.class, id);
		
		//Delete the Instructor from DB
		//This delete the InstructorDetail Object that is associated with the Instructor Object
		entityManager.remove(theInstructor);
		
	}

	@Override
	public InstructorDetail findInstructorDetailById(int id) {
		// TODO Auto-generated method stub
		
		return entityManager.find(InstructorDetail.class, id);
	}

}
