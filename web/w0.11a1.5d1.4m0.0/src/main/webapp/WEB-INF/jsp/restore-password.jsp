<html>
<head>
      <title>Restore password</title>
<meta charset="UTF-8">
<!-- need for responsive functionality -->
<meta name="viewport" content="width = device-width, initial-scale = 1.0">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" 
    integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
<style>
body {
text-align: center;
}
</style>
<script type="text/javascript">
      function validateResetPasswordForm() {
    	  
    	login = document.getElementById("labelLogin").value;  
    	email = document.getElementById("labelEmail").value;
    	
    	if (login == null || login == ""){  
    	 alert("Login can't be blank");  
          return false;
    	}
    	
    	//check for Latin letters
    	if(!(/^[a-zA-Z]+$/.test(login))) {
    		alert("Login only with Latin letters");
    		return false;
    	}
    	
    	mailSendConfirmation();
    	
      }
      
      function mailSendConfirmation() {
  		 alert("Mail was sent. Contact to system owner"); 
      }
  	  
    </script>
</head>
<body>

<div class="container text-center">
   <h2>If you have forgotten your password</h2>
   <h3>Write your login and email below and click button "Get password"</h3>
</div>

  <div class="container text-center">
    <form method="POST" id="resetPasswordForm" action="restore-password" onsubmit="return validateResetPasswordForm()">
         <div class="form-row">
            <div class="form-group col-md-4">
               <input type="text" class="form-control" id="labelLogin" name="login" placeholder="Login">
            </div>
            <div class="form-group col-md-4">
               <input type="email" class="form-control" id="labelEmail" name="email" placeholder="Email with @">
            </div>
        </div>
        <button type="submit" class="btn btn-large btn-info">Get Password</button>
   </form>
 </div>
    
    <div class="col-md-12 text-center">
         <a class="btn btn-large btn-info" href="../main">Back to main page</a>
    </div>
    
</body>
</html>