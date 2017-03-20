<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">
 	<c:set var="count"  value="0"/>
	<h3 class="text-center"> Searched Products  ${searchName}</h3>
 	<hr>
 	<c:choose>
  	  	<c:when test="${productList.size()==0}">
    		<div class="alert alert-danger text-center">No products available with this search criteria.</div>
 		</c:when>
 		<c:otherwise>
 			<div class="col-md-10 col-md-offset-1">
 				<div class="row">
 					<c:forEach var="product" items="${productList}">
 					<div class="col-md-6">
							<div class="row">
																		
	        <div class="col-sm-3" style="margin-left:70;padding-bottom:10px">
         <img src="resources/lib/images/ProductImages/${product.product_id}.jpg" style="width:240px;height:280px;">
         		<div style="font-size: 15px;  font-family:Calisto MT">
         		<div> ${product.name}</div>
         		
         		<center><h4>Rs.${product.price}</h4></center>
         </div>
         		<a href="cart_checkout" style="  width: 275%; box-shadow:0px 1px 2px 0px gray;"  class="btn btn-default btn-block">Buy Now</a>
         		
                 <c:if test="${not empty isUser}">
         		<a style="  width: 95%; box-shadow:0px 1px 2px 0px gray;"  class="btn btn-default btn-block" href="<c:url value='/addToCart?productId=${product.product_id}'/>">Add Bag</a>
         		</c:if>
         		</div>
		        	</div>
						</div>
						<c:set var="count"  value="${count+1}"/>
						<c:if test="${count==6}">
								</div>
								<div class="row">
								<c:set var="count"  value="0"/>
						</c:if>
					</c:forEach>
 				</div>
 			</div> 
		 </c:otherwise>
	</c:choose>
</div>
</body>
</html>