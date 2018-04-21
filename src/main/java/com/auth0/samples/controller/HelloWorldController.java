package com.auth0.samples.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.auth0.samples.classes.Api;


@Controller
public class HelloWorldController
{
	@RequestMapping("/generateQuestions")
	public String generateQUestions()
	{
		Api api = new Api();
		
		String questions = api.generateQuestions();
		
		return questions;
	}
	
	@GetMapping("/hello")
	public String index(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model)
	{
		
		model.addAttribute("name", name);
		
		return "hello";
	}
}
