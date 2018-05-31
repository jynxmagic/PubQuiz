package com.auth0.samples.controller;

import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.samples.classes.Api;

@Component
@RestController
@RequestMapping("/generate")
public class GenerateController {
	
	@RequestMapping(value="/generateQuestions", method=RequestMethod.GET)
	public String generateQuestions()
	{
		Api api = new Api();
		
		String questions = api.generateQuestions();
		
		return questions;
	}
	
	

}
