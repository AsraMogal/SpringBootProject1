package com.luv2code.springboot.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

	//create a mapping for hello world
	
	@GetMapping("/helloworld")
	public String sayHello(Model theModel)
	{
		theModel.addAttribute("theDate", new java.util.Date());
		
		//we have thymeleaf in pom.xml. Spring automatically configures to look for helloworld.html file in src/main/resources/templates/helloworld.html
		return "helloworld";
	}
}
