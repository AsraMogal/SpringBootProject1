package com.luv2code.cruddemo.DAO;

import com.luv2code.cruddemo.Entity.Instructor;
import com.luv2code.cruddemo.Entity.InstructorDetail;

public interface AppDAO {

	public void save(Instructor theInstructor);
	
	public Instructor findInstructorById(int id);
	
	public void deleteinstructorById(int id);
	
	public InstructorDetail findInstructorDetailById(int id);
	
	public void deleteInstructorDetailById(int id);
}
