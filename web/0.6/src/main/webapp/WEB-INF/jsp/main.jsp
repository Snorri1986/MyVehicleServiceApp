<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
      
      <!-- ready to commit 25.1 -->
      <form:form method="POST" id="authForm" action="https://ws-mvs-login.herokuapp.com/login" modelAttribute="subscriberAuthModelRequest"> 
      <!--  -->
         <table>
            <tr>
                <td><form:label path="username">login:</form:label></td>
                <td><form:input path="username"/></td>
            </tr>
            
            <tr>
                <td><form:label path="password">password:</form:label></td>
                <td><form:input path="password"/></td>
            </tr>
            
             <tr>
                <td><input type="submit" value="Submit"/></td>
            </tr>
         </table>
      </form:form>
      
      <form:form method="POST" id="regForm" style="float: right;" action="https://ws-mvs-login.herokuapp.com/register" modelAttribute="subscriberModel">
          <table>
            <tr>
                <td><form:label path="username">login:</form:label></td>
                <td><form:input path="username"/></td>
            </tr>
            
            <tr>
                <td><form:label path="password">password:</form:label></td>
                <td><form:input path="password"/></td>
            </tr>
            
            <tr>
                <td><form:label path="firstname">name:</form:label></td>
                <td><form:input path="firstname"/></td>
            </tr>
            
             <tr>
                <td><form:label path="lastname">lastname:</form:label></td>
                <td><form:input path="lastname"/></td>
            </tr>
            
            <tr>
                <td><input type="submit" value="Submit"/></td>
            </tr>
         </table>
      </form:form>
   </body>
</html>