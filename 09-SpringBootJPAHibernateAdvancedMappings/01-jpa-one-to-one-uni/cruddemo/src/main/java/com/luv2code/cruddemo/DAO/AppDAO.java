package com.luv2code.cruddemo.DAO;

import com.luv2code.cruddemo.Entity.Instructor;

public interface AppDAO {

	public void save(Instructor theInstructor);
	
	public Instructor findInstructorById(int id);
	
	public void deleteinstructorById(int id);
}
