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
    	  
    	name = document.getElementById("login").value;  
    	password = document.getElementById("userpass").value;
    	
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
     </script>
      
   </head>
   <body>
      <h2 style="text-align:center">${message}</h2>
      <div class="dividline">
      </div>
      
      <div id="authHeader">
      <h3>Log In:</h3>
      </div>
      
      <div id="registerHeader">
      <h3>Registration:</h3>
      </div>
      
      <form:form method="POST" id="authForm" action="main/workdesk" onsubmit="return validateAuthForm()" modelAttribute="subscriberAuthModelRequest"> 
         <table>
            <tr>
                <td><form:label path="username">login:</form:label></td>
                <td><form:input id="login" path="username" style="margin-left: -70px;"/></td>
            </tr>
            
            <tr>
                <td><form:label path="password">password:</form:label></td>
                <td><form:password id="userpass" path="password" style="margin-left: -70px;"/></td>
            </tr>
            
            <tr>
                <td><input type="submit" value="Submit" style="margin-left: 90px;"/></td>
            </tr>
         </table>
      </form:form>
      
      
      <form:form method="POST" id="regForm" style="float: right;" action="main/vehicle-register" modelAttribute="subscriberRegModelRequest">
          <table>
            <tr>
                <td><form:label path="username" style="margin-left: -5px;">login:</form:label></td>
                <td><form:input path="username" style="margin-left: -80px;"/></td>
            </tr>
            
            <tr>
                <td><form:label path="password" style="margin-left: -5px;">password:</form:label></td>
                <td><form:password path="password" style="margin-left: -80px;"/></td>
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