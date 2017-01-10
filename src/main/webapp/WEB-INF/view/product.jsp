<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

 </head>
<body>

<div class="container">
  <h2>ADD PRODUCT</h2>
   ${message }
  <form action="addproduct" method="post" enctype="mutipart/form-data">
    <div class="table-responsive">
      <input type="text" class="col-sm-4" name="ID" placeholder="ID" required>
    </div>
    <br>
  <div class="table-responsive">
      <input type="name" class="col-sm-4" name="name" placeholder="Name" required>
    </div>
    <br>
     <div class="table-responsive">
      <input class="col-sm-4" name="price" placeholder="Price" required>
    </div>
   <br>
   <div class="table-responsive">
	<input type="number" class="col-sm-4" name="quantity" placeholder="Quantity" required>
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
      <input type="file" path="image" class="col-sm-3" name="image" placeholder="Image">
    </div>
    <br>
  <div class="table-responsive">
  <button type="submit" class="btn btn-default">Add Product</button>
  </div>
  </form>
   <a button type="submit" class="btn btn-default"  href ="producttable">View Product Table</a>
</div>
</body>
</html>