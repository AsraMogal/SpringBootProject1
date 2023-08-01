package com.microservicesdemo.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	@RequestMapping("/Hi")
	public @ResponseBody String HiThere()
	
	{
		return "Hello World";
	}

}
