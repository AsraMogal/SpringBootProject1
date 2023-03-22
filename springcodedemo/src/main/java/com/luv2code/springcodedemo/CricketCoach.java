package com.luv2code.springcodedemo;

import org.springframework.stereotype.Component;

@Component //Spring Container creates and manages Bean 
public class CricketCoach implements Coach{

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice Fast Bowling for 15 Minutes Daily";
	}

}
