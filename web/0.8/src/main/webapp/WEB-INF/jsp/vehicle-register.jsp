<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta charset="UTF-8">
<title>Vehicle Registration</title>
<style>
form {
margin: 0 auto;
width:250px;
}
</style>
</head>
<body onload="alert('Registration was successful')"> 
<h2 style="text-align: center;">Welcome on Vehicle Registration form!</h2>
<form:form method="GET" action="../main">
<input type="submit" value="Back to main page"/>
</form:form>
</body>
</html>
