<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false"%>
<html>
<head>
<meta charset="UTF-8">
<title>WorkDesk</title>
<style>
form {
margin: 0 auto;
width:250px;
}

#locflags {
	position: absolute;
    right:0px;
    top:0px;
}
</style>
</head>
<body onload="alert('Authorization was successful')"> 
<h2 style="text-align: center;">Welcome on workdesk!</h2>
<form:form method="GET" action="../main">
<input type="submit" value="Back to main page"/>
</form:form>
<!-- TODO: change URL in href  --> 
      <div id="locflags">
         <a href="../workdesk"><img src="<c:url value="/resources/images/uk.png" />"></a>
         <a href="../workdesk"><img src="<c:url value="/resources/images/rus.png" />"></a>
      </div>
<!--  -->
</body>
</html>
