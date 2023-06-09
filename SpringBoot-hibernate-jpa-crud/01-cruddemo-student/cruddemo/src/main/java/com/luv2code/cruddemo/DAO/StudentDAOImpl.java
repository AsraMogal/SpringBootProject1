package com.luv2code.cruddemo.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository //helps in component scanning and is applied to Dao Implementation.It is a sub annotation of @component
public class StudentDAOImpl implements StudentDao{

	//define entity manager field
	private EntityManager entityManager;
	
	public StudentDAOImpl() {
		
	}
	
	//inject entity manager using constructor injection
	@Autowired
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

	@Override
	public Student findById(int id) {
		return entityManager.find(Student.class, id);
	}

	@Override
	public List<Student> findAll() {
		//JPA Query Language works on entity name and fileds .here Studnt is not the table name instead the entity class name
		TypedQuery<Student> theQuery = entityManager.createQuery("From Student",Student.class);
		return theQuery.getResultList();
	}
	
	@Override
	public List<Student> findByLastName(String lastName) {
		
		//create query to fetch list of students by last name Student and lastname are entity class names and filed names in entity class
		//named paramters are prefixed with colon like :theData its like a placeholder
		TypedQuery<Student> theQuery = entityManager.createQuery("From Student WHERE lastname= :theData",Student.class);
		
		//set the theData parameter
		theQuery.setParameter("theData",lastName);
		
		//return the result
		return theQuery.getResultList();
	}

	//to Update the Student Last Name
	@Override
	@Transactional //Transactional since we are making modification in database
	public void updateStudent(Student theStudent) {
		// TODO Auto-generated method 
		entityManager.merge(theStudent);
		//if you want to update multiple rows then you need to create the below query.
		//int rows_updated= entiyManager.createQuery("Update Student where lastname= 'Mogal'",Student.class).executeUpdate();
		
		
	}

	@Override
	@Transactional //since deletion modifies the database
	public void delete(int studentId) {
		// TODO Auto-generated method stub
		Student student = entityManager.find(Student.class,studentId);
		
		//deleates a record with this studentId
		entityManager.remove(student);
	}

	@Override
	@Transactional
	public int deleteAllStudents() {
		// TODO Auto-generated method stub
		
		return entityManager.createQuery("Delete from Student").executeUpdate();
		
		
	}


}
