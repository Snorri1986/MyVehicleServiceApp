<html>
<head>
      <title>Change password</title>
<meta charset="UTF-8">
<!-- need for responsive functionality -->
<meta name="viewport" content="width = device-width, initial-scale = 1.0">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" 
    integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
</head>
<!-- ready to commit task 52.5 -->
<div class="container text-center">
   <h2>Fill the form below and push "Send" button</h2>
</div>
<!--  -->
<!-- need test task 52.5 -->
<form method="POST" id="changePasswordForm" action="change-password">
  <div class="form-group col-md-4">
    <input type="password" class="form-control" id="oldPwd" aria-describedby="oldPwdHlp" placeholder="Enter Old Password">
    <small id="oldPwdHlp" class="form-text text-muted">Write here old password</small>
  </div>
  <div class="form-group col-md-4">
    <input type="password" class="form-control" id="newPwd" aria-describedby="newPwdHlp" placeholder="New Password">
    <small id="newPwdHlp" class="form-text text-muted">Write here new password</small>
  </div>
  <div class="form-group col-md-4">
    <input type="password" class="form-control" id="confirmNewPwd" aria-describedby="newPwdConfirm" placeholder="Confirm New Password">
    <small id="newPwdConfirm" class="form-text text-muted">Confirm new password</small>
  </div>
  <button type="submit" class="btn btn-primary">Send</button>
</form>
<button class="btn btn-primary">Cancel</button>
<a class="btn btn-primary" href="../main">Back to main page</a>
<!--  -->
<body>
</body>
</html>