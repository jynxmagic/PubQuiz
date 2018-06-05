package com.auth0.samples.classes;

import java.util.ArrayList;
import java.util.Collections;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class Service {
		
	public String retriveQuestions()
	{
		Api api = new Api();
	
		JSONObject response = api.makeRequest("40");
		JSONArray questions = response.getJSONArray("results");
		
		JSONObject rebuilt_questions = new JSONObject();
		
		for (int i = 0; i < questions.length(); i++) 
		{
			JSONObject block = questions.getJSONObject(i);
		    String question = JSONObject.quote(block.getString("question"));
		    
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
			}

		
		JSONObject rebuilt_response = new JSONObject();
		
		rebuilt_response.append("response_code", "0");
		
		rebuilt_response.append("results", rebuilt_questions);
		
		String string_response = rebuilt_response.toString();
			
		return string_response;
	}
	
  private String getFirstWord(String text) {
	    int index = text.indexOf(' ');
	    if (index > -1) 
	    {
	      return text.substring(0, index);
	    } 
	    else {
	      return text;
	    }
  }   
}
