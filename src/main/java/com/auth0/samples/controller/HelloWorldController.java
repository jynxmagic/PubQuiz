package com.auth0.samples.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.samples.classes.Api;

@RestController
@RequestMapping("/generateQuestions")
public class HelloWorldController
{
	@GetMapping
	public String sayHello()
	{
		Api api = new Api();
		
		String questions = api.generateQuestions();
		
		return questions;
	}
}
