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

<div class="col-sm-12">
<div  style="width:83%; margin-left:112; padding-bottom:px; background-image: url('resources/lib/images/12.jpg');background-repeat:no-repeat;">
			
	<div class="container"  style=" margin-left:60;width:500px;">

		<h4 style="margin-left:54;font-family:Bell MT;"><br>Become <b>PRAHA.COM</b> INSIDER and be the<br>
			first to hear about new collections,collaborations<br>
			and exclusive offers.</h4>
		
		<br>
     <div>
      <lable  style="font-size: 20px; font-family: serif background-color : red; color: red"/>  ${errormsg} </lable>
		</div>
		<div class="col-sm-offset-1 col-sm-11" style=" margin-right:80;padding-top:px;">
		<form  class="form-horizontal"role="form" action="signup">
		<div class="col-sm-11">
			<br>
			<div class="form-group" style="box-shadow:0px 1px 2px 0px gray;">
		<input type="text" class="form-control" name="name" placeholder="Enter Name*" required>
			</div>
			<div class="form-group" style="box-shadow:0px 1px 2px 0px gray;">
				 <input type="email" class="form-control" name="email" placeholder="Enter Email-ID*" required>
			</div>
			<div class="form-group" style="box-shadow:0px 1px 2px 0px gray;">
				 <input type="password"	class="form-control" name="password" placeholder="Enter Password*" required>
			</div>
			<div class="form-group" style="box-shadow:0px 1px 2px 0px gray;">
				 <input type="number" class="form-control" name="contact" placeholder="Enter Mobile Number*" required>
			</div>
			<div class="form-group" style="box-shadow:0px 1px 2px 0px gray;">
			 <input type="text"	class="form-control" name="address" placeholder="Enter Address*" required>
			</div>
			
			<!--  <div class="checkbox">
				<label><input type="checkbox">Subscribe to the
					PRADHA.COM Newsletter</label>
			</div> -->
			
			<br>
	   <div class="form-group">
       <center><button type="submit" class="btn btn-default btn-block" style="font-family:Bell MT; box-shadow:0px 1px 2px 0px gray;"><b>Sign-Up</b></button></center>
    </div>
   </div>
</form>
			</div>
		</div>
		</div>
		</div>

  
</body>
</html>
