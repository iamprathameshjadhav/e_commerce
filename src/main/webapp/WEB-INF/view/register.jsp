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
	
</head>
<body>



	<div class="container">
		<br> <span>Become <a "href="homepage">PRAHA.COM</a> INSIDER and be the<br>
			first to hear about new collections,<br> collaborations and
			exclusive offers.
		</span>
		<br>
     <div>
      <lable  style="font-size: 20px; font-family: serif background-color : red; color: red"/>  ${errormsg} </lable>
		</div>
		<form  class="form-horizontal"role="form" action="signup" method="post">
		<div class="col-sm-6">
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
	   <div class="form-group">
        <button type="submit" class="btn btn-default">Sign-Up</button>
    </div>
   

			</div>
		</form>
	</div>
	<br>
	<div class="container">
		<span> By creating an account, I agree to PRADHA.COM Terms of use and Privacy policy</span>
    </div>
</body>
</html>
