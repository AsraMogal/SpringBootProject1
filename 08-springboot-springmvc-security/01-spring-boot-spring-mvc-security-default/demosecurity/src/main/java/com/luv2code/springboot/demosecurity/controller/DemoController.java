package com.luv2code.springboot.demosecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

	@GetMapping("/")
	public String showHone()
	{
		//home is the view name in src/main/resources/templates
		return "home";
	}
	
	@GetMapping("/leaders")
	public String showLeaders()
	{
		return "leaders";
	}
	
	@GetMapping("/systems")
	public String showSystems()
	{
		return "system";
	}
}
