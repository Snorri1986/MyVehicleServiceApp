<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false"%>
<html>
   <head>
      <title>Welcome</title>
      <link href="resources/css/mainPageStyle.css" rel="stylesheet">
      <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
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
      
      <div class="container"> 
      <form method="post" id="authForm" action="#">
      <label for="fnameauth">login:</label>
      <input type="text" id="fnameauth" name="login" placeholder="login...">
      <label for="fpassauth">pass:</label>
      <input type="password" id="fpassauth" name="password" placeholder="password...">
      <input type="submit" style="margin-left: 100px;" value="Submit">
      </form> 
      </div> 
       
      <div class="container"> 
      <form method="post" id="regForm" style="float: right;" action="#">
      <label for="fnamereg">login:</label>
      <input type="text" id="fnamereg" name="login" placeholder="login...">
      <label for="fpassreg">pass:</label>
      <input type="password" id="fpassreg" name="password" placeholder="password...">
      <label for="fnativename">name:</label>
      <input type="text" id="fnativename" name="name" placeholder="native name...">
      <label for="fsurname">sname:</label>
      <input type="text" id="fsurname" name="surname" placeholder="surname...">
      <input type="submit" style="margin-left: 100px;" value="Submit">
      </form> 
      </div> 
   </body>
</html>