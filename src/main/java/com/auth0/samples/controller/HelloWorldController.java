package com.auth0.samples.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.auth0.samples.classes.Api;


@RestController
@RequestMapping("/")
public class HelloWorldController
{
	@RequestMapping("/generateQuestions")
	public String generateQUestions()
	{
		Api api = new Api();
		
		String questions = api.generateQuestions();
		
		return questions;
	}
	
	@RequestMapping("/")
	public String index()
	{
		return "hello";
	}
}
