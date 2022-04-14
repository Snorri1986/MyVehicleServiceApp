<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false"%>
<html>  
   <head>
      <title>Welcome</title>
      <link href="resources/css/mainPageStyle.css" rel="stylesheet"> 
      <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
        
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
      	
     }
      
    </script>
   </head>
   <body>
   
      <h2 style="text-align:center">Welcome on MyServiceVehicleApplication web page</h2>
          <div class="dividline">
      </div>
     
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
                <td><input type="submit" value="Submit" style="margin-left: 90px;"/></td>
            </tr>
         </table>
            <!--  need test task 39.2.1 do not delete-->
            <!-- <a href="#" style="margin-left: 165px;margin-top:100px;">Restore password</a> -->
            <!--  -->
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
                <td><input type="submit" value="Submit" style="margin-left: 90px;"/></td>
            </tr>
         </table>
      </form:form>
    </body>
</html>