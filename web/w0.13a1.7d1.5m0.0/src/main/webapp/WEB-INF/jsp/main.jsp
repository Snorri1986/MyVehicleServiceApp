<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false"%>
<html>  
   <head>
      <title>Welcome</title>
      <link href="resources/css/mainPageStyle.css" rel="stylesheet"> 
      <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
   <!-- need for responsive functionality -->
   <meta name="viewport" content="width = device-width, initial-scale = 1.0">
   <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" 
   integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
   
   <script type="text/javascript">
      function validateAuthForm() {
    	  
    	name = document.getElementById("loginAuth").value;  
    	password = document.getElementById("userpassAuth").value;
    	
    	if (name == null || name == ""){  
    	 alert("Login can't be blank");  
          return false;
    	}
    	
    	if (password == null || password == ""){  
       	 alert("Password can't be blank");  
             return false; 
       	}
    	
    	//check for Latin letters
    	if(!(/^[a-zA-Z]+$/.test(name))) {
    		alert("Login only with Latin letters");
    		return false;
    	}
    	
    	saveSubscriberLogin();
    	
      }
      
      
      function validateRegForm() {
    	  
    	const minPassLength = 5;
    	  
    	name = document.getElementById("loginRegister").value;  
      	password = document.getElementById("userpassRegister").value;
      	
        if (name == null || name == ""){  
      	 alert("Login can't be blank");  
            return false;
      	}
      	
      	if (password == null || password == ""){  
         	 alert("Password can't be blank");  
               return false; 
         	}
      	
      	//check for Latin letters
      	if(!(/^[a-zA-Z]+$/.test(name))) {
      		alert("Login only with Latin letters");
      		return false;
      	}
      	
      	if(password.length < minPassLength ) {
      		alert("Password must be longer");  
            return false;
      	}
      	
      	saveSubscriberLoginAfterReqistration();
     }
      
     function saveSubscriberLogin() {
    	  sessionStorage.setItem('usrLogin',document.getElementById("loginAuth").value);
     }
     
     function saveSubscriberLoginAfterReqistration() {
    	  sessionStorage.setItem('usrLogin',document.getElementById("loginRegister").value);
     }
   </script>
   </head>
   <body>
   
      <div class="container text-center">
          <h2>Welcome on MyServiceVehicleApplication web page</h2>
      </div>
      
      <div class="dividline"></div>
     
      <div id="authHeader">
          <h2 style="text-align:center">Log In:</h2>
      </div>
      
      <div id="registerHeader">
          <h2 style="text-align:center">Registration:</h2>
      </div>
      
      <form:form method="POST" id="authForm" action="main/workdesk" onsubmit="return validateAuthForm()" modelAttribute="subscriberAuthModelRequest"> 
         <table>
            <tr>
                <td><form:label path="username">login:</form:label></td> 
                <td><form:input id="loginAuth" path="username" style="margin-left: -70px;"/></td>
            </tr>
            
            <tr>
                <td><form:label path="password">password:</form:label></td> 
                <td><form:password id="userpassAuth" path="password" style="margin-left: -70px;"/></td>
            </tr>
            
            <tr>
                <td><input class="btn btn-primary" type="submit" value="Submit" style="margin-left: 100px;"></td>
            </tr>
         </table>
      </form:form>
      
      <form:form method="POST" id="regForm" style="float: right;" action="main/vehicle-register" onsubmit="return validateRegForm()" modelAttribute="subscriberRegModelRequest">
          <table>
            <tr>
                <td><form:label path="username" style="margin-left: -5px;">login:</form:label></td>
                <td><form:input id="loginRegister" path="username" style="margin-left: -80px;"/></td>
            </tr>
            
            <tr>
                <td><form:label path="password" style="margin-left: -5px;">password:</form:label></td>
                <td><form:password id="userpassRegister" path="password" style="margin-left: -80px;"/></td>
            </tr>
            
            <tr>
                <td><form:label path="firstname" style="margin-left: -5px;">name:</form:label></td>
                <td><form:input path="firstname" style="margin-left: -80px;"/></td>
            </tr>
            
            <tr>
                <td><form:label path="lastname" style="margin-left: -5px;">lastname:</form:label></td>
                <td><form:input path="lastname" style="margin-left: -80px;"/></td>
            </tr>
            
            <tr>
                <td><input class="btn btn-primary" type="submit" value="Submit" style="margin-left: 105px;"></td>
            </tr>
         </table>
      </form:form>
    </body>
</html>