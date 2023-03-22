package com.luv2code.springcodedemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
//@Lazy
public class BaseballCoach implements Coach {

	public BaseballCoach()
	{
		System.out.println("In Constructor: "+getClass().getSimpleName());
	}
	
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Pratice Baseball 15 Minutes Daily";
	}

}
