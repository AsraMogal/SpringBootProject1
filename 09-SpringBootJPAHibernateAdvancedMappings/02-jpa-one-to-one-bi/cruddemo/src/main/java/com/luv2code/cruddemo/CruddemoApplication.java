package com.luv2code.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.luv2code.cruddemo.DAO.AppDAO;
import com.luv2code.cruddemo.Entity.Instructor;
import com.luv2code.cruddemo.Entity.InstructorDetail;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

		
	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO)
	{
		return runner->{
			//createInstructor(appDAO);
			//findInstructor(appDAO);
			//deleteInstructor(appDAO);
			//findInstructorDetail(appDAO);
			deleteInstructorDetail(appDAO);
		};	
	}


	private void deleteInstructorDetail(AppDAO appDAO) {
		// TODO Auto-generated method stub
		int id=3;
		
		System.out.println("Deleting Instructor Detail");
		
		appDAO.deleteInstructorDetailById(id);
		
		System.out.println("Done!!");
	}


	private void findInstructorDetail(AppDAO appDAO) {
		// TODO Auto-generated method stub
		
		int id=2;
		
		//get the Instructor Detail Object 
		InstructorDetail instructorDetail = appDAO.findInstructorDetailById(id);
		
		//Print InstructorDetailObject
		System.out.println("Printing Instrcutor Detail Object"+ instructorDetail.toString());
		
		//Print the Associated Instructor Object
		System.out.println("Printing Associated Instructor Object "+ instructorDetail.getInstructor());
	}


	private void deleteInstructor(AppDAO appDAO) {
		// TODO Auto-generated method stub
		int id=1;
		
		System.out.println("Deleting an Instructor");
		appDAO.deleteinstructorById(id);
		
		System.out.println("Instrcutor Deleted");
		
	}


	private void findInstructor(AppDAO appDAO) {

		
		int id=1;
		
		//fetching the instructor details by Id
		Instructor instructor = appDAO.findInstructorById(id);
		
		System.out.println("Instructor Details "+ instructor.toString());
	}


	private void createInstructor(AppDAO appDAO) {

		/** //Create Instructor
		Instructor instructor = new Instructor("asra","mogal","mogalasra@gmail.com");
		
		//Create InstructorDetail object
		//First AssociateObject i.ee below object will be inserted in table because the Instrcutor table needs a foreign key
		InstructorDetail instructorDetail = new InstructorDetail("http;//youtube.com/minifoodaholic","cooking");
		
		*/
		
		//Create Instructor
		Instructor instructor = new Instructor("roohi","mogal","roohi@gmail.com");
		
		//Create InstructorDetail object
		//First AssociateObject i.ee below object will be inserted in table because the Instrcutor table needs a foreign key
		InstructorDetail instructorDetail = new InstructorDetail("http;//youtube.com/minifoodaholic","singing");

		
		instructor.setInstructorDetail(instructorDetail);
		
		System.out.println("Saving Instructor");
		
		//this will also save the InstructorDetail object
		//Because of CascadeType.ALL
		
		appDAO.save(instructor);
		
		System.out.println("Done");
	}
}
