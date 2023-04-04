package com.luv2code.cruddemo;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.luv2code.cruddemo.DAO.StudentDao;
import com.luv2code.cruddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {  

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(StudentDao theStudentDao)
	
	{
		return runner->{
			//createStudent(theStudentDao);
			
			//createMultipleStudents(theStudentDao);
			
			//readStudent(theStudentDao);
			
			//readAllStudents(theStudentDao);
			
			queryToGetStudentsByLastName(theStudentDao);
		};
	}

	private void queryToGetStudentsByLastName(StudentDao theStudentDao) {
		
		// pass the last name
		List<Student> students=theStudentDao.findByLastName("mogal");
		
		//display the students by last name
		for(Student std :students)
		{
			System.out.println(std);
		}
		
		
	}

	private void readAllStudents(StudentDao theStudentDao) {
		//read all the students from student table
		List<Student> students = theStudentDao.findAll();
		
		//display students data
		for(Student stud:students)
		{
			System.out.println(stud);
		}
		
	}

	private void readStudent(StudentDao theStudentDao) {
		//Create a student
		Student tempstudent = new Student("muneer","G","muneer@gmail.com");
		
		//save a student 
		theStudentDao.save(tempstudent);
		
		//display the student id
		int id = tempstudent.getId();
		System.out.println(id);
		
		//find the student details based on id
		Student stud = theStudentDao.findById(id);
		
		//display the fetched details
		System.out.println("The Fetched Student Details"+stud);
		
	}

	private void createMultipleStudents(StudentDao theStudentDao) {
		//Creating the student objects
		System.out.println("Creating Student Objects");
		Student student1 = new Student("roohi","Mogal","mogalroohi@gmail.com");
		Student student2 = new Student("firdose","Mogal","mogalfirdose@gmail.com");
		Student student3 = new Student("farhath","AVM","farhath@gmail.com");
		Student student4 = new Student("syedbaig","Mogal","mogalsyedbaig@gmail.com");
		
		//Ssaving the Student Objects
		System.out.println("Saving the Student Object using Dao");
		theStudentDao.save(student1);
		theStudentDao.save(student2);
		theStudentDao.save(student3);
		theStudentDao.save(student4);
		
		System.out.println("Student Object Saved");
	}

	private void createStudent(StudentDao theStudentDao) {
		//Creating the student object
		System.out.println("Creating Student Object");
		Student student = new Student("asra","Mogal","mogalasra@gmail.com");
		
		//Ssaving the Studnet Object
		System.out.println("Saving the Student Object using Dao");
		theStudentDao.save(student);
		System.out.println("Student Object Saved");
		
		
	}

}
