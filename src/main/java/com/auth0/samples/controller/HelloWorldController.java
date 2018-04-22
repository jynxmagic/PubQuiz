package com.auth0.samples.controller;



import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@Controller
@RequestMapping("/")
public class HelloWorldController
{
	
	@RequestMapping(value = "/", method=RequestMethod.GET)
	public String index(Model model)
	{
				
		return "index";
	}
}
