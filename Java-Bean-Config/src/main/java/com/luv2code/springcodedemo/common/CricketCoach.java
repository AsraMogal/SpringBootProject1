package com.luv2code.springcodedemo.common;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component //Spring Container creates and manages Bean 
//By deafult scope of this bean is singleton
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
