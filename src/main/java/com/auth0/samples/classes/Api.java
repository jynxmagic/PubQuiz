package com.auth0.samples.classes;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
public class Api {
	
	protected final String sessionToken = "64808f9f8aa181ba1f3a765226c0f175e3ca46fdc2208df7c6e690f3440fbde4";
	
	
	public ArrayList generateQuestions()
	{
        URL questionUrl = new URL("https://opentdb.com/api.php?amount=1&token=\"+sessionToken");
        URLConnection yc = questionUrl.openConnection();
        BufferedReader in = new BufferedReader(
                                new InputStreamReader(
                                yc.getInputStream()));
        String inputLine;
        
        ArrayList questions = new ArrayList();

        while ((inputLine = in.readLine()) != null) 
        		questions.add(inputLine)
        in.close();
        
        return questions;
	}
}
