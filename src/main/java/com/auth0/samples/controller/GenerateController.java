package com.auth0.samples.controller;

import com.auth0.samples.classes.Service;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@Component
@RestController
@RequestMapping("/generate")
public class GenerateController {
	
	@RequestMapping(value="/generateQuestions", method=RequestMethod.GET)
	public String generateQuestions()
	{
		Service service = new Service();
		String questions = service.retriveQuestions();
		
		return questions;
	}
	
	

}
