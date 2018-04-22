package com.auth0.samples.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import org.json.JSONObject;
import org.springframework.stereotype.Component;


@Component
public class Api {	

	public String generateQuestions()
	{
		String response = new String("0");

		try
		{
			URL questionUrl = new URL("https://opentdb.com/api.php?amount=40");
			URLConnection questionConnection = questionUrl.openConnection();

			questionConnection.setDoOutput(true);
			Scanner scanner = new Scanner(questionUrl.openStream());
			response = new String(scanner.useDelimiter("\\Z").next());
			scanner.close();	        
		}
		catch(Exception ex)
		{

		}
	
		
		return response;
	}
}
