<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false"%>
<html>
<head>
      <title>Change password</title>
<meta charset="UTF-8">
<!-- need for responsive functionality -->
<meta name="viewport" content="width = device-width, initial-scale = 1.0">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" 
    integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
<script type="text/javascript">
function validateChangePasswordFields() {
   
	oldpassword = document.getElementById("oldPwd").value;
    newpassword = document.getElementById("newPwd").value;
    confpassword = document.getElementById("confirmNewPwd").value;
    	
    if (oldpassword == "" || newpassword == "" || confpassword == ""){  
    	 alert("Fields can't be blank");  
          return false;
    }
    
    if (newpassword != confpassword){  
   	 alert("Confirmation field doesn't match with new password field");  
         return false;
   }
    
}

function clearChangePasswordFormFields() {
	 document.getElementById("oldPwd").value = "";
	 document.getElementById("newPwd").value = "";
	 document.getElementById("confirmNewPwd").value = "";
}

function setSubscriberLogin() {
	 document.getElementById("lgn").value = sessionStorage.getItem('usrLogin');
}

</script>
</head>
<body onload="setSubscriberLogin()"> 

<div class="container text-center">
   <h2>Fill the form below and push "Send" button</h2>
</div>

<form:form method="POST" id="changePasswordForm" action="change-password-send" onsubmit="return validateChangePasswordFields()" modelAttribute="chPasswordRequestModel"> 
   <div class="form-group col-md-4">
    <form:input type="text" path="login" class="form-control" id="lgn" aria-describedby="lgnDesc" placeholder="Login" readonly="readonly" />
    <small id="lgnDesc" class="form-text text-muted">Your login. Not editable field.</small> 
  </div> 
  <div class="form-group col-md-4">
    <form:input type="password" path="oldPassword" class="form-control" id="oldPwd" aria-describedby="oldPwdHlp" placeholder="Enter Old Password" />
    <small id="oldPwdHlp" class="form-text text-muted">Write here old password</small>
  </div>
  <div class="form-group col-md-4">
    <form:input type="password" path="newPassword" class="form-control" id="newPwd" aria-describedby="newPwdHlp" placeholder="New Password" />
    <small id="newPwdHlp" class="form-text text-muted">Write here new password</small>
  </div>
  <div class="form-group col-md-4">
    <form:input type="password" path="passConfirmation" class="form-control" id="confirmNewPwd" aria-describedby="newPwdConfirm" placeholder="Confirm New Password" />
    <small id="newPwdConfirm" class="form-text text-muted">Confirm new password</small>
  </div>
  <button type="submit" class="btn btn-primary">Send</button>
</form:form>

<button class="btn btn-primary" onclick="clearChangePasswordFormFields()">Cancel</button>
<a class="btn btn-primary" href="../main">Back to main page</a>
</body>
</html>