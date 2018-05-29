<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>New Age - Start Bootstrap Theme</title>
    
    

    <!-- Bootstrap core CSS -->
	<link href="/resources/core/css/bootstrap.min.css" rel="stylesheet" />
	<link href="/resources/core/css/hello.css" rel="stylesheet" />
	<link href="/resources/core/css/font-awesome.min.css" rel="stylesheet" />
	<link href="/resources/core/css/simple-line-icons.css" rel="stylesheet" />

    <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Catamaran:100,200,300,400,500,600,700,800,900" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Muli" rel="stylesheet">

    <!-- Plugin CSS -->
    <link href="/resources/core/css/device-mockups.min.css" rel="stylesheet" />

    <!-- Custom styles for this template -->
        <link href="/resources/core/css/new-age.min.css" rel="stylesheet" />
    
  </head>

  <body id="page-top">

    <header class="masthead">
      <div class="container h-100" style="width: auto">
      	<div class="row h-100  justify-content-center align-items-center">
          <div class="col-12" style="text-align: center; line-height: 100vh">
              			<a href="#questions" id="download" class="btn btn-outline btn-xl js-scroll-trigger">Generate Quiz</a>
          </div>
         </div>
     </div>
    </header>

    <section class="download bg-primary text-center">
      <div class="container" style="width: auto">
        <div class="row">
          <div class="col-md-8 mx-auto" style="padding: 10px">
            <h2 class="section-heading">Here is your quiz!</h2>
            <ul id="questions">
            
            </ul>
            <div class="badges">
              <a class="badge-link" href="#"><img src="img/google-play-badge.svg" alt=""></a>
              <a class="badge-link" href="#"><img src="img/app-store-badge.svg" alt=""></a>
            </div>
          </div>
        </div>
      </div>
    </section>
    <footer>
      <div class="container" style="width: auto;">
        <p>&copy; Your Website 2018. All Rights Reserved.</p>
        <ul class="list-inline">
          <li class="list-inline-item">
            <a href="#">Privacy</a>
          </li>
          <li class="list-inline-item">
            <a href="#">Terms</a>
          </li>
          <li class="list-inline-item">
            <a href="#">test</a>
          </li>
        </ul>
      </div>
    </footer>

    <!-- Bootstrap core JavaScript -->
    


    <script src="/resources/core/js/jquery.min.js"> </script>
      
     <script>
     $(document).ready(function(){
	     $('#download').click(function(){
	    	 $.ajax({url: window.location+"/generate/generateQuestions", success: function(result){
	    		 	 data = jQuery.parseJSON(result);
	    		 	 questions = data.results;
	    		 	 
	    		 	 console.log(questions);
	    		 	 
	    		 	 var i;
	    		 	 for(i = 0; i <= questions.length; i++)
	    		 	 {
	    		 		 var question;
	    		 		 
	    		 		 if(questions[i].type == "multiple")
	    		 		 {
	    		 			var multiple_choice = new Array();
	    		 			
	    		 			var x;
	    		 			
	    		 			for(x = 0; x <= questions[i].incorrect_answers.length; x++)
	    		 			{
	    		 				multiple_choice.push(questions[i].incorrect_answers[x]);
	    		 			}
	    		 			
	    		 			multiple_choice.push(questions[i].correct_answer);
	    		 			
	    		 			multiple_choice = shuffle(multiple_choice);
	    		 			
	    		 			question = questions[i].question;
	    		 			
	    		 			multiple_choice.forEach(function(element)
							{
	    		 				question = question + " " + element;
	    		 			});

	    		 		 }
	    		 		 else	 
	    		 		 {
	    		 			question =  questions[i].question;
	    		 		 }
	    		 		$("#questions").append('<li>Question '+(i)+': <span style="font-weight: bold">'+question+'</span> <br> '+questions[i].correct_answer+'</li>');
	    		     }
	    		 }})
	    	 });

	     function shuffle(a) {
	         var j, x, i;
	         for (i = a.length - 1; i > 0; i--) {
	             j = Math.floor(Math.random() * (i + 1));
	             x = a[i];
	             a[i] = a[j];
	             a[j] = x;
	         }
	         return a;
	     };
     });
    </script>
    
    <script src="/resources/core/js/bootstrap.bundle.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="/resources/core/js/jquery.easing.min.js"></script>
    <!-- Custom scripts for this template -->
    <script src="/resources/core/js/new-age-min.js"></script>

  </body>

</html>
