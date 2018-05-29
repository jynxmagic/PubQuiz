 $(document).ready(function(){
     $('#download').click(function(){
    	 $.ajax({url: window.location+"/generate/generateQuestions", success: function(result){
    		 	 data = jQuery.parseJSON(result);
    		 	 questions = data.results;
    		 	 
    		 	 console.log(questions);
    		 	 
    		 	 var i;
    		 	 for(i = 0; i <= questions.length; i++)
    		 	 {
    		 		$("#questions").append('<li>Question '+(i)+': <span style="font-weight: bold">'+questions[i].question+'</span> <br> '+questions[i].correct_answer+'</li>');
    		     }
    		 }})
    	 });
 });