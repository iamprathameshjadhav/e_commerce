<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>

<body background="<c:url value="/resources/lib/images/baground.jpg"/>" >
 <nav class="navbar">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="glyphicon glyphicon-home" href="adminnavbar" style="font-size: 40px; font-family: serif background-color : black; color: black">ADMIN</a>
 </div>
 </div>
 </nav>
<nav class="navbar navbar-default">
		<div class="container-fluid">

			<ul class="nav navbar-nav">
  	 <li><a style="font-size: 20px;" href="usertable">Manage</a></li>
   <li><a style="font-size: 20px;" href="category">Category</a></li>
   <li><a style="font-size: 20px;" href="supplier">Supplier</a></li>
    <li><a style="font-size: 20px;" href="product">Product</a></li>

      <!-- <a class="navbar-brand" href="category" style="font-size:25px; font-family:serif background-color:black;color:black">CATEGORY</a> -->
     <!--  <a class="navbar-brand" href="supplier" style="font-size:25px; font-family:serif background-color:black;color:black">SUPPLIER</a> -->
      <!-- <a class="navbar-brand" href="product" style="font-size:25px; font-family:serif background-color:black;color:black">PRODUCT</a> -->
     </ul>
       <ul class="nav navbar-nav navbar-right">
       	<li><a style="font-size: 20px;" href="homepage"><span
						class="glyphicon glyphicon-log-out"></span> Logout</a></li>

       <!-- <a class="navbar-brand"  href="homepage" style="font-size:25px;">Logout</a> -->
       </ul>
       
    </div>
</nav> 
</body>
</html>
					




<!-- <nav class="navbar navbar-default">
        <div class="container-fluid=">
			<ul class="nav navbar-nav">
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Admin</a>
					<ul class="dropdown-menu">
						<li><a href="#">Category</a></li>
						<li><a href="#">Supplier</a></li>
                        <li><a href="#">Product</a></li>
					</ul>
                    </li>
        <ul class="nav navbar-nav navbar-right">
		<li><a href="#"><spanclass="glyphicon glyphicon-user"></span>Logout</a></li>
			</ul>
        <ul class="nav navbar-nav navbar-right">
		<li><a href="#"><spanclass="glyphicon glyphicon-home"></span></a></li>
			</ul> -->
