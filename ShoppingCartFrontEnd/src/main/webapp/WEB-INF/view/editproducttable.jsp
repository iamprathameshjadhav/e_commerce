<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Product Table</title>
</head>
<body>
<div class="container">
  <h2>EDIT PRODUCT</h2>
  ${message }
  <form action="editproduct" method="post">
    <div class="table-responsive">
      <input type="text" class="col-sm-4" name="ID" placeholder="ID" required value=${product.product_id}>
    </div>
    <br>
  <div class="table-responsive">
      <input type="name" class="col-sm-4" name="name" placeholder="name" required value=${product.name}>
    </div>
     <br>
       <div class="table-responsive">
      <input type="name" class="col-sm-4" name="price" placeholder="price" required value=${product.price}>
    </div>
    <br>
      <div class="table-responsive">
      <input type="name" class="col-sm-4" name="quantity" placeholder="quantity" required value=${product.quantity}>
    </div>
    <br>
       <div class="table-responsive">
      <input type="name" class="col-sm-4" name="category_id" placeholder="Category-ID" required value=${product.category_id}>
    </div>
   <br>
    <div class="table-responsive">
      <input type="name" class="col-sm-4" name="supplier_id" placeholder="Supplier-ID" required value=${product.supplier_id}>
    </div>
  <br>
  <div class="table-responsive">
  <button type="submit" class="btn btn-default">Edit Product</button>
   <br>
   </div>
 </form>
 
 <a button type="submit" class="btn btn-default"  href ="producttable">View Product Table</a>
 
</body>
</html>