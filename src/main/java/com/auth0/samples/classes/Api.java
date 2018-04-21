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

public class Api {	

	public Map<String, Object> generateQuestions()
	{
		JSONObject response = new JSONObject();

		try
		{
			URL questionUrl = new URL("https://opentdb.com/api.php?amount=10");
			URLConnection questionConnection = questionUrl.openConnection();

			questionConnection.setDoOutput(true);
			Scanner scanner = new Scanner(questionUrl.openStream());
			response = new JSONObject(scanner.useDelimiter("\\Z").next());
			scanner.close();	        
		}
		catch(Exception ex)
		{

		}
		
		Map<String, Object> dataSet = response.toMap();
		
		return dataSet;
	}
}
