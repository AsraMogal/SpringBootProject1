package com.luv2code.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.demo.Entity.Student;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> students;
	
	// This method will be called only once after bean is created so its good option to load data
	@PostConstruct
	public void loaddata()
	{
		students = new ArrayList<>();
		students.add(new Student("asra","Mogal"));
		students.add(new Student("Roohi","Mogal"));
		students.add(new Student("Firdose","Mogal"));
	}
	
	//api endpoint to get list of students
	@GetMapping("/students")
	public List<Student> getStudents()
	{
		return students;
	}
	
	//define student/{StudentId} endpoint to return student at index
	//the studentId in @getmapping and @pathvariable should be same 
	@GetMapping("/student/{studentId}")
	public Student 	getStudent(@PathVariable int studentId)
	{
		//wrapping the code that might throw excrpion
		if((studentId>students.size()) || (studentId<0))
			{
				throw new StudentNotFoundException("Student Not found with Id "+studentId);
			}
		
		return students.get(studentId);
	}

}
