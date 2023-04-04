package com.luv2code.cruddemo.DAO;
import java.util.List;

import com.luv2code.cruddemo.entity.Student;

public interface StudentDao {
	void save(Student student);
	
	Student findById(int id);
	
	List<Student> findAll();
	
	List<Student> findByLastName(String lastName);
	
	void updateStudent(Student theStudent);
	
	void delete(int studentId);
	
	int deleteAllStudents();
}
