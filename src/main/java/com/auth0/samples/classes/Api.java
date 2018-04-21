package com.auth0.samples.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import org.json.JSONArray;

public class Api {	

	public List<Object> generateQuestions()
	{
		JSONArray response = new JSONArray();

		try
		{
			URL questionUrl = new URL("https://opentdb.com/api.php?amount=10");
			URLConnection questionConnection = questionUrl.openConnection();

			questionConnection.setDoOutput(true);
			Scanner scanner = new Scanner(questionUrl.openStream());
			response = scanner.useDelimiter("\\Z").next();
			scanner.close();	        
		}
		catch(Exception ex)
		{

		}
		
		List<Object> dataSet = response.toList();
		
		return dataSet;
	}
}
