package com.luv2code.springcodedemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springcodedemo.common.Coach;

@RestController //this class acts as a rest service 
public class DemoController {
	private Coach myCoach;
	/*
	 * @Autowired //This is field injection ,one of the ways of dependency injection
	 * private Coach myCoach;
	 */
	
	/*
	 * This is Constructor Injection
	 * @Autowired 
	 * DemoController(Coach myCoach)
	 * { this.myCoach = myCoach; }
	 */
	
	@Autowired //this is setter injection.You can also inject on any custom methods too
	public void setMyCoach(Coach myCoach) {
		this.myCoach = myCoach;
	}
	
	
	@GetMapping("/dailyworkout") //handles http request
	public String getDailyWorkout() {
		return myCoach.getDailyWorkout();
	}

}