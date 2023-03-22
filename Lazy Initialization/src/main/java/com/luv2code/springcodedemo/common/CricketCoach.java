package com.luv2code.springcodedemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component //Spring Container creates and manages Bean 
// spring will not create bean for this on app start up i will be created only when its needed
//@Lazy
public class CricketCoach implements Coach{

	public CricketCoach()
	{
		System.out.println("In Constructor: "+getClass().getSimpleName());
	}
	
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice Fast Bowling for 15 Minutes Daily:)";
	}

}
