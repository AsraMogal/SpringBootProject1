package com.luv2code.springcodedemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.luv2code.springcodedemo.common.*;

@Configuration
//This is java bean configuration
public class SportConfig {

	@Bean
	//the method name should be bean id which is class name with small first letter
	//we can also customize the bean name @Bean("swimbean") and in demo controller @Qualifier("swimbean")
	//We go for this when we have third-party class which we cant edit and to be make it available as spring bean we go for java config
	//example aws s3 client
	public Coach swimCoach()
	{
		return new SwimCoach();
	}
}
