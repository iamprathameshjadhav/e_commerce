<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
	 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
</head>
<body>
<div class="container">
   
		<div class="form-actions">
			<c:forEach items="${productList}" var="product">
			<div class="col-sm-3" style="margin-left:70;padding-bottom:10px">
         <img src="resources/lib/images/ProductImages/${product.product_id}.jpg" style="width:200px;height:200px;">
         		<h4> ${product.name}</h4>
         		<h4>Price:${product.price}</h4>
         		<a href="cart_checkout" class="btn btn-info">Buy Now</a>
         		<a style="font-size: 20px;" href="#"><span><img src=<c:url value="/resources/lib/images/shopping-bag.png"/>></span></a>
         		</div>
         	</c:forEach>
		</div>

	</div>

</body>
</html>