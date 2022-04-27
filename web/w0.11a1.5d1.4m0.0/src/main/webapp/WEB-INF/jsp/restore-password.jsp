<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false"%>
<html>
<head>
      <title>Restore password</title>
<!-- need test task 55 -->
<meta charset="UTF-8">
<!-- need for responsive functionality -->
<meta name="viewport" content="width = device-width, initial-scale = 1.0">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" 
    integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
<!--  -->
<style>
body {
text-align: center;
}

/*#resetPasswordForm {
    display: inline-block;
}*/

/* do not delete task 55 */
/*#returnToHome {
    margin: 0 auto;
    width:250px;
}*/
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

<!--  ready to commit task 55 -->
<div class="container text-center">
<h2>If you have forgotten your password</h2>
<h3>Write your login and email below and click button "Get password"</h3>
</div>
<!--  -->
    
    <!-- do not delete task 55 -->
    <!-- <form:form method="POST" id="resetPasswordForm" action="restore-password" onsubmit="return validateResetPasswordForm()"> 
         <table>
            <tr>
                <td><label for="labelLogin">login:</label></td>
                <td><input type="text" id="labelLogin" name="login" /></td>
                <td><label for="labelEmail">email:</label></td>
                <td><input type="text" id="labelEmail" name="email" /></td>
                <td><input type="submit" value="Get Password" /></td> 
            </tr>
         </table>
    </form:form> -->
    <!--  -->
    
    <!-- need test task 55 -->
    <form method="POST" id="resetPasswordForm" action="restore-password" onsubmit="return validateResetPasswordForm()">
         <div class="form-row text-center">
            <div class="form-group col-md-4">
               <label for="labelLogin">login:</label>
               <input type="text" class="form-control" id="labelLogin" name="login" placeholder="Login">
            </div>
            <div class="form-group col-md-4">
               <label for="labelEmail">email:</label>
               <input type="text" class="form-control" id="labelEmail" name="email" placeholder="Email with @">
            </div>
        </div>
   </form>
    <!--  -->
    
    
    <!-- ready to commit task 55 -->
    <div class="col-md-12 text-center">
         <a class="btn btn-large btn-info" href="../main">Back to main page</a>
    </div>
    <!--  -->
  
</body>
</html>