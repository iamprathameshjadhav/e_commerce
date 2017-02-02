<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration page</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 <script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.1/jquery.min.js"></script>	
	
	<script>
	 function initializeDropdown(){
		 $('.dropdown-toggle').dropdown();
	 }
	 </script>
</head>
<body>

<div class="col-sm-7">

	<div class="container well"  style="width:500px;">
	 <h1 class="well center" style=" font-family: Maiandra GD;"><center>REGISTER</center></h1>
		<center><i><br>Become <b>PRAHA.COM</b> INSIDER and be the<br>
			first to hear about new collections,<br> collaborations and
			exclusive offers.</i></center>
		
		<br>
     <div>
      <lable  style="font-size: 20px; font-family: serif background-color : red; color: red"/>  ${errormsg} </lable>
		</div>
		<div class="col-sm-offset-1 col-sm-11">
		<form  class="form-horizontal"role="form" action="signup" method="post">
		<div class="col-sm-11">
			<br>
			<div class="form-group">
				<label for="name">Name:</label> <input type="name"
					class="form-control" name="name" placeholder="Enter Name" required>
			</div>
			<div class="form-group">
				<label for="email">Email address:</label> <input type="email"
					class="form-control" name="email" placeholder="Enter Email-ID" required>
			</div>
			<div class="form-group">
				<label for="pwd">Password:</label> <input type="password"
					class="form-control" name="password" placeholder="Enter Password" required>
			</div>
			<div class="form-group">
				<label for="contact">Mobile number:</label> <input type="number"
					class="form-control" name="contact" placeholder="Enter Mobile Number" required>
			</div>
			<div class="form-group">
				<label for="address">Address:</label> <input type="text"
					class="form-control" name="address" placeholder="Enter Address" required>
			</div>
			
			<!--  <div class="checkbox">
				<label><input type="checkbox">Subscribe to the
					PRADHA.COM Newsletter</label>
			</div> -->
			
			<br>
	   <div class="form-group">
       <center><button type="submit" class="btn btn-success btn-block">Sign-Up</button></center>
    </div>
   </div>

			</div>
		</form>
		</div>
		</div>
	<!-- </div>
	<br>
	<div class="container">
		<span> By creating an account, I agree to PRADHA.COM Terms of use and Privacy policy</span>
    </div> -->
</body>
</html>
