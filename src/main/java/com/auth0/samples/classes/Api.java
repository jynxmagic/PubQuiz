package com.auth0.samples.classes;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import org.json.JSONObject;

public class Api {	

	public JSONObject generateQuestions()
	{
		JSONObject json = new JSONObject();

		try
		{
			URL questionUrl = new URL("https://opentdb.com/api.php?amount=10");
			URLConnection questionConnection = questionUrl.openConnection();

			questionConnection.setDoOutput(true);
			Scanner scanner = new Scanner(questionUrl.openStream());
			String questions = scanner.useDelimiter("\\Z").next();
			json = new JSONObject(questions);
			scanner.close();	        
		}
		catch(Exception ex)
		{

		}
		return json;
	}
}
