<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false"%>
<html>
   <head>
      <title>Welcome</title>
      <link href="resources/css/mainPageStyle.css" rel="stylesheet">
      <!-- ready to commit task 1 -->
      <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
      <!--  -->
   </head>
   <body>
      <h2 style="text-align:center">${message}</h2>
      <!-- ready to commit task 7 -->
      <div class="dividline"></div>
      <!--  -->
      
      <!-- need test task 2 -->
      <div id="authHeader">
      <h3>Log In:</h3>
      </div>
      
      <div class="container">
      <form method="post" id="authForm" action="#">
      <label for="fname">login:</label>
      <input type="text" id="fname" name="login" placeholder="login...">
      <label for="fpass">pass:</label>
      <input type="password" id="fpass" name="password" placeholder="password...">
      <input type="submit" style="margin-left: 100px;" value="Submit">
      </form> 
      </div>
      <!--  -->
   </body>
</html>