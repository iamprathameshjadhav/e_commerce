<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FOOTER</title>
<style>
/*footer*/
#footer{
	position: absolute;
	width: 100%;
	height: 300px;
	background-color: #f2f2f2;
}

#footer-logo{
	margin-left: 10px;
	width: 100px;
	height: 100px;
}
#footer-text{
	color: black;
	font-family: 'Raelway',sans-serif;
	text-align: inherit;
	font-weight: bold;
	margin-left: 100px;
	margin-top: -55px;
	text-transform: uppercase;
	letter-spacing: 0.1em;
}

#footer_links{
	position: absolute;
	width: 100%;
	height: 50px;
}
.footer-links{
	display: inline;
	font-family: sans-serif;
	color: black;
	text-decoration: none;
	padding: 5px;
	margin: 12px;
	margin-top: -30px;
	float: right;
}

.footer-links:hover{
	background-color: rgba(0, 0, 0, 0.2);
}

#footer_social{
	position: absolute;
	width: 600px;
	height: 140px;
	bottom: 20px;
	left: 50%;
	margin-left: -330px;
}

#join_us{
	font-family: 'Raelway',sans-serif;
	font-size: 18px;
	text-align: center;
	font-weight: bold;
	margin-top: 0;
}

#social_links_div{
	position: absolute;
	width: 500px;
	height: 50px;
	left: 50px;
	margin-left: -250px;
}
.social_links:link{
	 margin-left: 25px;


}/*footer*/
#footer{
	position: absolute;
	width: 100%;
	height: 300px;
	background-color:white;
}

#footer-logo{
	margin-left: 10px;
	width: 200px;
	height: 100px;
}
#footer-text{
	color: black;
	font-family: 'Raelway',sans-serif;
	text-align: inherit;
	font-weight: bold;
	margin-left: 100px;
	margin-top: -55px;
	text-transform: uppercase;
	letter-spacing: 0.1em;
}

#footer_links{
	position: absolute;
	width: 100%;
	height: 50px;
}
.footer-links{
	display: inline;
	font-family: sans-serif;
	color: black;
	text-decoration: none;
	padding: 5px;
	margin: 12px;
	margin-top: -30px;
	float: right;
}

.footer-links:hover{
	background-color: rgba(0, 0, 0, 0.2);
}

#footer_social{
	position: absolute;
	width: 600px;
	height: 140px;
	bottom: 20px;
	left: 50%;
	margin-left: -330px;
}

#join_us{
	font-family: 'Raelway',sans-serif;
	font-size: 18px;
	text-align: center;
	font-weight: bold;
	margin-top: 0;
}

#social_links_div{
	position: absolute;
	width: 500px;
	height: 50px;
	left: 50px;
	margin-left: -250px;
}
.social_links:link{
	 margin-left: 25px;


}

</style>
</head>
<body>

<div class="col-sm-offset-1 col-sm-10">
<div id="footer">
	
	<nav class="navbar navbar-default" style="height:90px";>
		<div class="container-fluid">

			<ul class="nav navbar-nav">
	<!-- <p id="footer-text">PRADHA.COM</p> -->
        <div id=footer_links class="col-sm-offset-0 col-sm-10">
       
        <img id="footer-logo" src=<c:url value="/resources/lib/images/log.png"/> id="logo">
        <a href="homepage" class="btn btn-success" style="background-color:grey;"><b>Home</b></a>
		<a href="login" class= "btn btn-success" style="background-color:grey;"><b>log-In</b></a>
  		<a href="register" class="btn btn-success" style="background-color:grey;"><b>Sign-Up</b></a>
      	<a href="aboutus" class="btn btn-success" style="background-color:grey;"><b>About Us</b></a>
  		</div>
  		</ul>
  		</div>
  		</nav>
  		
 	<div id="footer_social">
 	<div class="row">
 		<div class="col-sm-2">
 		</div>
 		<div class="col-sm-9">
  		<p id="join_us">Join us On</p>
  		<div id="social_links">
  			<a href="https://www.instagram.com/?hl=en" class="social_links"><img src=<c:url value="/resources/lib/images/insta.png"/>>
  			</a>
  			<a href="https://www.facebook.com/" class="social_links"><img src=<c:url value="/resources/lib/images/icon-fb.png"/>>
  			</a>
  			<a href="https://www.tumblr.com/" class="social_links"><img src=<c:url value="/resources/lib/images/tumblr.png"/>>
  			</a>
  			<a href="https://twitter.com/login" class="social_links"><img src=<c:url value="/resources/lib/images/twitter.png"/>>
  			</a>
  			<a href="https://plus.google.com/" class="social_links"><img src=<c:url value="/resources/lib/images/goggle.png"/>>
  			</a>
  			<a href="https://www.whatsapp.com/" class="social_links"><img src=<c:url value="/resources/lib/images/whatsapp.png"/>>
  			</a>
  		</div>
  		<div class="col-sm-1">
 		</div>
  		</div>
  		</div>
<br>
	<p><center><b>PRADHA.COM © 2016 | All Rights Reserved</b></center></p>

</div>
</div>
</div>
</body>
</html>