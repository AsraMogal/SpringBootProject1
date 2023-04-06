package com.luv2code.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.demo.Entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	//api endpoint to get list of students
	
	@GetMapping("/students")
	public List<Student> getStudents()
	{
		List<Student> students = new ArrayList<>();
		
		students.add(new Student("asra","Mogal"));
		students.add(new Student("Roohi","Mogal"));
		students.add(new Student("Firdose","Mogal"));
		
		return students;
	}
}
