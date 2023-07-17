package com.luv2code.springboot.demosecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;

@Configuration
public class DemoSecurityConfig {
	
	@Bean
	public InMemoryUserDetailsManager userDetailsManager()
	{
		UserDetails John = User.builder()
							.username("John")
							.password("{noop}test123")
							.roles("EMPLOYEE").build();
		
		UserDetails Mary = User.builder()
				.username("Mary")
				.password("{noop}test123")
				.roles("EMPLOYEE","MANAGER").build();
		
		UserDetails Susan = User.builder()
				.username("Susan")
				.password("{noop}test123")
				.roles("EMPLOYEE","MANAGER","ADMIN").build();
		
		return new InMemoryUserDetailsManager(John,Mary,Susan);
	}
	

	@Bean 
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		//any request to the app must be authenticated.
		http.authorizeHttpRequests(configurer->
		configurer
		.requestMatchers("/").hasRole("EMPLOYEE")
		.requestMatchers("/leaders/**").hasRole("MANAGER")
		.requestMatchers("/systems/**").hasRole("ADMIN")
		.anyRequest().authenticated()
				)
		.formLogin(form ->
				form 
				.loginPage("/showMyLoginPage")
				.loginProcessingUrl("/authenticateTheUser")
				.permitAll()
				)
				.logout(logout->logout.permitAll()
		);
		return http.build();
	}
}
