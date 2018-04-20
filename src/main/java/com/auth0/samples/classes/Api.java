package com.auth0.samples.classes;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
public class Api {	
	
	public String generateQuestions()
	{
        String questions = new String();
       
        
		try
		{
	        URL questionUrl = new URL("https://opentdb.com/api.php?amount=10");
	        URLConnection questionConnection = questionUrl.openConnection();
	        
	        questionConnection.setDoOutput(true);
	        Scanner scanner = new Scanner(questionUrl.openStream());
	        questions = scanner.useDelimiter("\\Z").next();
	        scanner.close();	        
		}
		catch(Exception ex)
		{
			
		}
        return questions;
	}
}
