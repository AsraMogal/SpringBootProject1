package com.luv2code.springboot.cruddemo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class},scanBasePackages= {"com.luv2code.springboot.crudemo1.dao","com.luv2code.springboot.crudemo1.rest","com.luv2code.springboot.crudemo1.entity"})
public class Cruddemo1Application {

	
	public static void main(String[] args) {
		SpringApplication.run(Cruddemo1Application.class, args);
	}

}
