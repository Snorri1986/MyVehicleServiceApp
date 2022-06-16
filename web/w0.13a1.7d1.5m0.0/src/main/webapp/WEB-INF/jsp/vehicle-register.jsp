<html>
<head>
<meta charset="UTF-8">
<!-- need for responsive functionality -->
<meta name="viewport" content="width = device-width, initial-scale = 1.0">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" 
    integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
<title>Vehicle Registration</title>
<script type="text/javascript">
function setSubscriberLogin() {
	 document.getElementById("labelLogin").value = sessionStorage.getItem('usrLogin');
}

function validateAddVehicleForm() {
	login = document.getElementById("labelLogin").value;
	brand = document.getElementById("labelBrand").value;
	model = document.getElementById("labelModel").value;
	dateofmanuf = document.getElementById("labelDateOfManufacture").value;
	totalMilleage = document.getElementById("labelTotalMilleage").value;
	vehicleType = document.getElementById("labelType").value;
	stateNumber = document.getElementById("labelStateNumber").value;
	
	if (login == null || login == ""){  
   	 alert("Login can't be blank");  
         return false;
   	}
	
	if (brand == null || brand == ""){  
	   	 alert("Brand can't be blank");  
	         return false;
	}
	
	if (model == null || model == ""){  
	   	 alert("Model can't be blank");  
	         return false;
	}
	
	if (dateofmanuf == null || dateofmanuf == ""){  
	   	 alert("Date of manufacturing can't be blank");  
	         return false;
	}
	
	if (totalMilleage == null || totalMilleage == ""){  
	   	 alert("Total nilleage can't be blank");  
	         return false;
	}
	
	if (vehicleType == null || vehicleType == ""){  
	   	 alert("Vehicle type can't be blank");  
	         return false;
	}
	
	if (stateNumber == null || stateNumber == ""){  
	   	 alert("State number can't be blank");  
	         return false;
	}
}

</script>
<style>
body {
text-align: center;
}
</style>
</head>
<body onload="alert('Registration was successful'),setSubscriberLogin()"> 
<h2 style="text-align: center;">Welcome on Vehicle Registration form!</h2>
<div class="container text-center">
    <form method="POST" id="addNewVehicle" action="#" onsubmit="return validateAddVehicleForm()">
         <div class="form-group row"> <!-- TODO ready to commit task 65 -->
            <input type="text" class="form-control" id="labelLogin" name="login">
            <input type="text" class="form-control" id="labelBrand" name="brand" placeholder="Brand">
            <input type="text" class="form-control" id="labelModel" name="model" placeholder="Model">
            <input type="text" class="form-control" id="labelDateOfManufacture" name="dateofmanuf" placeholder="Date of Manufacturing.Example: 2010">
            <input type="text" class="form-control" id="labelTotalMilleage" name="totalmilleage" placeholder="TotalMilleage.Example: 95600">
            <input type="text" class="form-control" id="labelLastServiceCheck" name="lastSrvCheck" placeholder="LastServiceCheck.Example: 18.03.2022">
            <input type="text" class="form-control" id="labelType" name="vehicleType" placeholder="Example: Car Boat Bicycle Motobycicle Bus Truck">
            <input type="text" class="form-control" id="labelStateNumber" name="vehicleStateNumber" placeholder="State number">
        </div>
        <button type="submit" class="btn btn-large btn-info">Add new vehicle</button>
   </form>
 </div>
<div class = "btn-group">
   <a class="btn btn-large btn-info mr-1" href="../main">Back to main page</a>
</div>
</body>
</html>