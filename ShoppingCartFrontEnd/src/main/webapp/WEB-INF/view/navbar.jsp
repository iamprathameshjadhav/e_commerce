<html>
<head>
<title>www.Pradha.com</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
	 <script>
	 function initializeDropdown(){
		 $('.dropdown-toggle').dropdown();
	 }
	 </script>
</head>


<body>
  <div class="col-sm-offset-1 col-sm-10" >
	<nav class="navbar">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" style="font-size: 40px; font-family: Maiandra GD; color: black" href="homepage"><b>PRADHA.COM</b></a>

<!--  <ul class="nav navbar-nav navbar-right">
 <li><a  class="dropdown-toggle" data-toggle="popover" style="font-size: 15px;padding-top:5px;padding-bottom:4px;" href="#"><span><img src=<c:url value="/resources/lib/images/myac.png"/>></span></a></li>

 </ul> -->

		</div>
		</div>
			 		
	</nav>
	<nav class="navbar navbar-default" style="box-shadow:0px 1px 2px 0px gray;">
		<div class="container-fluid">
		
		<ul class="nav navbar-nav">
    <c:forEach items="${categoryList}" var="category">
    
    <li class="dropdown"><a style="font-family: Maiandra GD;" class="dropdown-toggle" id="dLabel-${category.name}" data-toggle="dropdown" href="#"><b>${category.name}</b></a>
    
    	<ul class="dropdown-menu" aria-labelledby="dLabel-${category.name}">
    	
    		<c:forEach items="${subcategoryList}" var="subcategory">
            <li><a style="font-family: Maiandra GD;" href="<c:url value='/displayProduct?categoryId=${category.category_id}&subCategoryId=${subcategory.id}'/>">${subcategory.name}</a></li>
          	</c:forEach>
        </ul>
    
    </li>
    
    </c:forEach>
    
    </ul>
 <div class="col-sm-offset-1 col-sm-4">
				<form class="navbar-form" role="search" action ="searchProduct" >
					<div class="input-group"  style="padding-top:3px;">
						<input style=" width: 150%;box-shadow:0px 0px 1px 0px gray;" type="text" class="form-control" placeholder="What are you looking for today?" name="search"  list="products">
						
					</div>
				</form>
			</div> 

		
			
			
			<ul class="nav navbar-nav navbar-right">
     
				
				<c:if test="${empty isUser}">
				
				<li><a style="font-family: Maiandra GD;font-size: 15px;" href="register"><span
						class="glyphicon glyphicon-user"></span> <b>Sign Up</b></a></li>
				
				<li><a style=" font-family: Maiandra GD;font-size: 15px;" href="login"><span
						class="glyphicon glyphicon-log-in"></span><b> Login</b></a></li>
			    
				</c:if>
				
				<c:if test="${not empty isUser}">
				<li style="font-size: 18px;  font-family: Maiandra GD;padding-top:13px;"><b>Hello: ${name} </b></li>
				 <li><a style=" font-family: Maiandra GD;font-size: 15px;" href="carttable"><span><img src=<c:url value="/resources/lib/images/shopping-bag.png"/>></span><b>My Bag(${cartItemCount})</b></a></li>
				
				<li><a style="font-family: Maiandra GD;font-size: 15px;" href="logout"><span
						class="glyphicon glyphicon-log-out"></span><b>Logout</b></a></li>
				
				</c:if>
				
			</ul>
		</div>
	</nav>
</div>

</body>

</html>
