package com.luv2code.springcodedemo.common;

//here am not giving @component instead we will get this bean by java configuration class
public class SwimCoach implements Coach {

	public SwimCoach()
	{
		System.out.println("In Constructor :," +getClass().getSimpleName());
	}
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "swim half an hour daily";
	}

}
