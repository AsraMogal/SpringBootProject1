package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SayHello {
	
	@GetMapping("/")
	public String Hello() {
		return "Hello Wolrd";
	}
}
