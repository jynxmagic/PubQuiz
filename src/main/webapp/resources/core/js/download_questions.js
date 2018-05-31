 $(document).ready(function(){
     $('#download').click(function(){
    	 $.ajax({url: window.location+"/generate/generateQuestions", success: function(result){
    		 	 data = jQuery.parseJSON(result);
    		 	 questions = data.results;
    		 	 
    		 	 console.log(questions);
    		 	 
    		 	 var i;
    		 	 for(i = 0; i <= 40; i++)
    		 	 {
    		 		$("#questions").append('<li>Question '+(i)+': <span style="font-weight: bold">'+questions[0][i][0].question+'</span> <br> '+questions[0][i][0].correct_answer+'</li>');
    		     }
    		 }})
    	 });
 });