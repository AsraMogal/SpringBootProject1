package com.luv2code.springcodedemo.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component //Spring Container creates and manages Bean 
//By deafult scope of this bean is singleton
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
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
