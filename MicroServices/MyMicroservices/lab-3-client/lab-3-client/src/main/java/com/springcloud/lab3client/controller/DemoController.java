package com.springcloud.lab3client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	
	@Value("${lucky-word}") 
	String luckyWord;

	@GetMapping("/lucky-word")
	public String showLuckyWord()
	{
		return "hi"+luckyWord;
	}
}
