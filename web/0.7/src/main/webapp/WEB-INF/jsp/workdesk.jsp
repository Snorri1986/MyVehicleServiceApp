<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta charset="UTF-8">
<title>WorkDesk</title>
<style>
form {
margin: 0 auto;
width:250px;
}
</style>
</head>
<body onload="alert('Authorization was successful')"> 
<h2 style="text-align: center;">Welcome on workdesk!</h2>
<form:form method="GET" action="../main">
<input type="submit" value="Back to main page"/>
</form:form>
</body>
</html>
