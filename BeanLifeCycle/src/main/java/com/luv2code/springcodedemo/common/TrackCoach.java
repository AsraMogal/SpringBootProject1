package com.luv2code.springcodedemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach{

	public TrackCoach()
	{
		System.out.println("In Constructor: "+getClass().getSimpleName());
	}
	
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Tracking 15 minutes Practice Daily";
	}

}
