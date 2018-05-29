package com.auth0.samples.classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;


@Component
public class Api {	

	public JSONObject generateQuestions()
	{
		JSONObject response = new JSONObject("0");

		try
		{
			URL questionUrl = new URL("https://opentdb.com/api.php?amount=40");
			URLConnection questionConnection = questionUrl.openConnection();

			questionConnection.setDoOutput(true);
			Scanner scanner = new Scanner(questionUrl.openStream());			
			response = new JSONObject(scanner.useDelimiter("\\Z").next());
			scanner.close();	        
		}
		catch(Exception ex)
		{

		}
		
		if(response.get("response_code").toString() == "0")
		{
			JSONObject questions = response.getJSONObject("results");
			
			JSONObject rebuilt_questions = new JSONObject("");
			
			Iterator<?> keys = questions.keys();

			int i = 0;
			
			while( keys.hasNext() ) {
			    JSONObject block = (JSONObject) keys.next();
			    
			    String question = block.getString("question");
			    
			    String firstWord = getFirstWord(question);
			    
			    
			    //add more first words which prefix multiple choice questions.
			    if(firstWord == "Which" || firstWord == "which")
			    {
			    	//question is multiple choice. add options to question.
			    	
			    	ArrayList<String> possible_answers = new ArrayList<String>();
			    	
			    	JSONArray incorrect_answers = new JSONArray();
			    	
			    	incorrect_answers = block.getJSONArray("incorrect_answers");
			    	
			    	int j;
			    	
			    	for(j = 0; j <= incorrect_answers.length(); j++)
			    	{
			    		possible_answers.add(incorrect_answers.getString(j));
			    	}
			    	
			    	possible_answers.add(block.getString("correct_answer"));
			    	
			    	//shuffle answers so correct answer is not always at the bottom
			    	Collections.shuffle(possible_answers);
			    	
			    	for (String s : possible_answers)
			    	{
			    	    question = question + "   " +  s;
			    	}
			    	
			    	JSONObject question_block = new JSONObject();
			    	
			    	question_block.append("question", question);
			    	
			    	question_block.append("correct_answer", block.getString("correct_answer"));
			    	
			    	
			    	rebuilt_questions.append(Integer.toString(i), question_block);
			    	
			    }
			    else
			    {
			    	rebuilt_questions.append(Integer.toString(i), block);
			    }
			    
			    i++;
			}
			
			JSONObject rebuilt_response = new JSONObject("");
			
			rebuilt_response.append("response_code", 0);
			
			rebuilt_response.append("results", rebuilt_questions);
			
			response = rebuilt_response;
		}
		else
		{
			//failed to get response / error
		}
	
		
		return response;
	}
	
  private String getFirstWord(String text) {
	    int index = text.indexOf(' ');
	    if (index > -1) { // Check if there is more than one word.
	      return text.substring(0, index); // Extract first word.
	    } else {
	      return text; // Text is the first word itself.
	    }
	  }
}
