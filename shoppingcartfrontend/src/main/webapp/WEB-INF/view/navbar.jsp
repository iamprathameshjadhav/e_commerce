
<head>
<title>navigation bar</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>


<body>
  <div class="col-sm-offset-1 col-sm-10">
	<nav class="navbar">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" style="font-size: 40px; font-family: Maiandra GD; color: black" href="homepage"><b>PRADHA.COM</b></a>

		</div>
		</div>
			 		
	</nav>




	<nav class="navbar navbar-default" style="baground-color:black";>
		<div class="container-fluid">

			<ul class="nav navbar-nav">
				<c:forEach items="${categoryList}" var="category">
				<li><a href="#" ><b> ${category.name}</b></a> 
				
				</li>
				</c:forEach>
				
	</ul>
			
			<ul class="nav navbar-nav navbar-right">
     
				
				<c:if test="${empty isUser}">
				
				<li><a style="font-size: 15px;" href="register"><span
						class="glyphicon glyphicon-user"></span> <b>Sign Up</b></a></li>
				
				<li><a style="font-size: 15px;" href="login"><span
						class="glyphicon glyphicon-log-in"></span><b> Login</b></a></li>
			    
				</c:if>
				
				<c:if test="${not empty isUser}">
				<li style="font-size: 15px;"> hello: ${name} </li>
				 <li><a style="font-size: 15px;" href="#"><span><img src=<c:url value="/resources/lib/images/shopping-bag.png"/>></span><b>My Bag</b></a></li>
				
				<li><a style="font-size: 15px;" href="logout"><span
						class="glyphicon glyphicon-log-out"></span><b>Logout</b></a></li>
				</c:if>
			</ul>
		</div>
		</head>
	</nav>
</div>

</body>


