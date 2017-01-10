<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>Insert title here</title>
</head>
<body>

<div class="col-sm-6">             
  <table class="table">
    <thead>
      <tr>
        <th>PRODUCT_ID</th>
        <th>NAME</th>
        <th>PRICE</th>
        <th>QUANTITY</th>
        <th>CATEGORY_ID</th>
        <th>SUPPLIER_ID</th>
         <th>EDIT</th>
          <th>DELETE</th>
      </tr>
    </thead>
   <tbody>
   <c:forEach items="${ProductList}" var="product">
        <tr>
        
            <td>${product.product_id}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>${product.quantity}</td>
            <td>${product.category_id}</td>
            <td>${product.supplier_id}</td>
             <td><a href="<c:url value='/manage_product_edit?id=${product.product_id}'/>" button class="btn btn-success btn-sm">Edit</a></td>
            <td><a href="<c:url value='/manage_product_remove?id=${product.product_id }'/>" button class="btn btn-danger btn-sm">Delete</a></td>
            
            </tr>
            </c:forEach>
            </tbody>   
  </table>
</div>
</body>
</html>