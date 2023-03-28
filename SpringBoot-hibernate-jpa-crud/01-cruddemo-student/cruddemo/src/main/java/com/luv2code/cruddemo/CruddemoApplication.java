package com.luv2code.cruddemo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
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
			createStudent(theStudentDao);
		};
	}

	private void createStudent(StudentDao theStudentDao) {
		// TODO Auto-generated method stub
		System.out.println("Creating Student Object");
		Student student = new Student("asra","Mogal","mogalasra@gmail.com");
		System.out.println("Saving the Student Object using Dao");
		theStudentDao.save(student);
		System.out.println("Student Object Saved");
		
		
	}

}
