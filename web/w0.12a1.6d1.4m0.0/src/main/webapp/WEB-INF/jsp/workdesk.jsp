<html>
<head>
<meta charset="UTF-8">
<!-- need for responsive functionality -->
<meta name="viewport" content="width = device-width, initial-scale = 1.0">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" 
    integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
<title>WorkDesk</title>
<style>
.dividline {
   width: 100%; 
   text-align: center; 
   /*border-bottom: 1px solid #000;*/
   border-bottom: 6px double black;
   line-height: 0.1em;
   margin: 10px 0 20px; 
} 

/* ready to commit task 63.3 */
#vehicleInfo {
padding-top: 20px;
}
/**/
</style>
<script type="text/javascript">
function getSubscriberLogin() {
	document.getElementById("subLogin").innerHTML = sessionStorage.getItem('usrLogin');
}
</script>
</head>
<body onload="alert('Authorization was successful'),getSubscriberLogin()"> 
<h2 style="text-align: center;">Welcome on workdesk!<div id="subLogin"></div></h2> 
<div class = "btn-group">
    <a class="btn btn-large btn-info mr-1" href="../main">Back to main page</a>
    <a class="btn btn-large btn-info mr-1" href="../main/change-password">Change my password</a>
</div>

<div class="dividline"></div>

<div class = "btn-group" id="lstVehicles">
    <a class="btn btn-large btn-info mr-1" href="#">Vehicle 1</a>
    <a class="btn btn-large btn-info mr-1" href="#">Vehicle 2</a>
    <a class="btn btn-large btn-info mr-1" href="#">Vehicle 3</a>
    <a class="btn btn-large btn-info mr-1" href="#">Vehicle 4</a>
    <a class="btn btn-large btn-info mr-1" href="#">Vehicle 5</a>
</div>

<div id="vehicleInfo">
<p>Brand: <div id="brand"></div></p>
<p>Model: <div id="model"></div></p>
<p>Date of manufacture: <div id="dateOfMunuf"></div></p>
<p>Total mileage: <div id="lstMileage"></div></p>
<p>Last service check: <div id="lstServiceChk"></div></p>
</div>

</body>
</html>
