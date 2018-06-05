package com.auth0.samples.classes;

import java.util.Scanner;
import java.net.URL;
import java.net.URLConnection;
import org.json.JSONObject;
import org.springframework.stereotype.Component;


@Component
public class Api {	

	public JSONObject makeRequest(String number)
	{
		JSONObject response = new JSONObject();
		try
		{
			URL questionUrl = new URL("https://opentdb.com/api.php?amount="+number+"&category=9");
			URLConnection questionConnection = questionUrl.openConnection();

			questionConnection.setDoOutput(true);
			Scanner scanner = new Scanner(questionUrl.openStream());			
			response = new JSONObject(scanner.useDelimiter("\\Z").next());
			scanner.close();	        
		}
		catch(Exception ex)
		{
				//failed request
		}
		
		return response;
	}
}
