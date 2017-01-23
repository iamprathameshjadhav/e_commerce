<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

 </head>
<body>

<div class="col-sm-offset-2 col-sm-10">
  <h1 class="well center" style=" font-family: Maiandra GD; width:400px;"><center>ADD PRODUCT</center></h1>
  
  <form:form action="addproduct"  method="post" enctype="multipart/form-data">
  <div class="well" style="width:400px;">
   ${pmessage}
    <div class="table-responsive">
      <input type="text" class="col-sm-11" name="ID" placeholder="ID" required>
    </div>
    <br>
  <div class="table-responsive">
      <input type="name" class="col-sm-11" name="name" placeholder="Name" required>
    </div>
    <br>
     <div class="table-responsive">
      <input class="col-sm-11" name="price" placeholder="Price" required>
    </div>
   <br>
   <div class="table-responsive">
	<input type="number" class="col-sm-11" name="quantity" placeholder="Quantity" required>
			</div>
    <br>
    <div>
  <label >Category-ID</label>
     <select name="category_id">
    <c:forEach var="list" items="${CategoryList}">
    <option>${list.category_id}</option>
    </c:forEach>
    </select>
    </div>
    <br>
     <div>
  <label >Supplier-ID</label>
     <select name= "supplier_id">
    <c:forEach var="list" items="${SupplierList}">
    <option>${list.supplier_id}</option>
    </c:forEach>
    </select>
    </div>
    <br>
    <div class="table-responsive">
      <input type="file" path="image" class="col-sm-11" name="image" placeholder="Image">
    </div>
    <br>
  <div class="table-responsive">
  <button type="submit" class="btn btn-default btn-block">Add Product</button>
  </div>
  </div>
</form:form>
 <div class="col-sm-offset-0 col-sm-4">
   <a button type="submit" class="btn btn-success btn-block" href ="producttable" style="margin-bottom:40px; margin-top:-10px;">View Product Table</a>
</div>
</body>
</html>