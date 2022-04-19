<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false"%>
<html>
<head>
      <title>Restore password</title>
<style>
body {
text-align: center;
}

#resetPasswordForm {
    display: inline-block;
}

#returnToHome {
    margin: 0 auto;
    width:250px;
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
    	
    	//check email
    	// temporary disable before task # 51
    	/*if(!(/^\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}$/.test(login))) {
    		alert("Email incorrect. Need check");
    		return false;
    	}*/
      }
    </script>
</head>
<body>
<h2 style="text-align: center;">If you have forgotten your password</h2>
<h3 style="text-align: center;">Write your login and email below and click button "Get password"</h3>
    <form:form method="POST" id="resetPasswordForm" action="/mvs-web/main/restore-password" onsubmit="return validateResetPasswordForm()"> 
         <table>
            <tr>
                <td><label for="labelLogin">login:</label></td>
                <td><input type="text" id="labelLogin" name="login" /></td>
                <td><label for="labelEmail">email:</label></td>
                <td><input type="text" id="labelEmail" name="email" /></td>
                <td><input type="submit" value="Get Password" /></td>
            </tr>
         </table>
    </form:form>
    
    <form:form method="GET" id="returnToHome" action="../main">
         <input type="submit" value="Back to main page"/>
    </form:form>
  
</body>
</html>