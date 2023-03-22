package com.luv2code.springcodedemo.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Pratice Baseball 15 Minutes Daily";
	}

}
