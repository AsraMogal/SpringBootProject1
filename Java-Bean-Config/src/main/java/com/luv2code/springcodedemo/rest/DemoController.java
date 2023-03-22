package com.luv2code.springcodedemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springcodedemo.common.Coach;

@RestController //this class acts as a rest service 
//@Lazy
public class DemoController {
	
	private Coach myCoach;
	
	  @Autowired 
	  DemoController(@Qualifier("swimCoach") Coach myCoach){ 
		  System.out.println("In Constructor: "+getClass().getSimpleName());
		  this.myCoach = myCoach;
		  }

	@GetMapping("/dailyworkout") //handles http request
	public String getDailyWorkout() {
		return myCoach.getDailyWorkout();
	}

}