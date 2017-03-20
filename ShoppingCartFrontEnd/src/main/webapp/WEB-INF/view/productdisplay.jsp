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
			<c:forEach items="${productListBySubCategory}" var="product">
			<div class="col-sm-3" style="margin-left:70;padding-bottom:10px">
         <img src="resources/lib/images/ProductImages/${product.product_id}.jpg" style="width:240px;height:280px;">
         		<div style="font-size: 15px;  font-family:Calisto MT">
         		<div> ${product.name}</div>
         		
         		<center><h4>Rs.${product.price}</h4></center>
         </div>
         		<a href="cart_checkout" style="  width: 95%; box-shadow:0px 1px 2px 0px gray;"  class="btn btn-default btn-block">Buy Now</a>
         		
                 <c:if test="${not empty isUser}">
         		<a style="  width: 95%; box-shadow:0px 1px 2px 0px gray;"  class="btn btn-default btn-block" href="<c:url value='/addToCart?productId=${product.product_id}'/>">Add Bag</a>
         		</c:if>
         		</div>
         	</c:forEach>
		</div>

	</div>

</body>
</html>