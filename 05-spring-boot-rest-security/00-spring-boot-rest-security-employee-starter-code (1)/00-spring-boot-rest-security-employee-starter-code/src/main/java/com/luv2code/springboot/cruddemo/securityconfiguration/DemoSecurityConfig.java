package com.luv2code.springboot.cruddemo.securityconfiguration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

//Since we have defined users,passwords and roles here,Spring Boot will not use the details in application.properties
@Configuration
public class DemoSecurityConfig {
	
	//Add support for JDBC ..no more hardcoded user details
	@Bean
	public UserDetailsManager userDetailsManager(DataSource datasource)
	{
		
		return new JdbcUserDetailsManager(datasource); //this tells spring security to use jdbc authentication with our datasource
	}
	
	  //restricting access based on roles
    @Bean 
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
    {
    	http.authorizeHttpRequests(configurer->
    	configurer
    			.requestMatchers(HttpMethod.GET,"/api/employees").hasRole("EMPLOYEE")
    			.requestMatchers(HttpMethod.GET,"/api/employees/**").hasRole("EMPLOYEE")
    			.requestMatchers(HttpMethod.PUT,"/api/employees").hasRole("MANAGER")
    			.requestMatchers(HttpMethod.POST,"/api/employees").hasRole("MANAGER")
    			.requestMatchers(HttpMethod.DELETE,"/api/employees/**").hasRole("ADMIN")
    		);
    	
    	//use HTTP Basic Auth
    	http.httpBasic(Customizer.withDefaults());
    	
    	//disable cross site request forgery(CSRF)
    	//in general not require for statless REST APIS that use POST,PUT,DELETE
    	http.csrf(csrf->csrf.disable());
    	
    	return http.build();
    			
    } 


}

/* The below code is for using the user details stored in java source code
 * @Bean
public InMemoryUserDetailsManager userDetailsManager()
{
	UserDetails John = User.builder().username("John").password("{noop}test123").roles("Employee").build();
	
	UserDetails Mary = User.builder().username("Mary").password("{noop}test123").roles("Employee","Manager").build();
	
	UserDetails Susan = User.builder().username("Susan").password("{noop}test123").roles("Employee","Manager","Admin").build();
	
	return new InMemoryUserDetailsManager(John,Mary,Susan);
	
} */
