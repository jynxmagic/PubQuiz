package com.auth0.samples.controller;



import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.auth0.samples.classes.Api;

@Component
@Controller
@RequestMapping("/")
public class HelloWorldController
{
	@RequestMapping(value="/generateQuestions", method=RequestMethod.GET)
	public String generateQuestions()
	{
		Api api = new Api();
		
		String questions = api.generateQuestions();
		
		return questions;
	}
	
	@RequestMapping(value = "/test", method=RequestMethod.GET)
	public String index(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model)
	{
		
		model.addAttribute("name", name);
		
		return "index";
	}
}
