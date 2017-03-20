<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EDIT SUPPLIER</title>
</head>
<body>
<div class="container">
  <h2>EDIT SUPPLIER</h2>
    ${message }
  <form action="editsupplier" method="post">
    <div class="table-responsive">
      <input type="text" class="col-sm-4" name="ID" placeholder="ID" required value=${supplier.supplier_id}>
    </div>
    <br>
  <div class="table-responsive">
      <input type="name" class="col-sm-4" name="name" placeholder="Name" required value=${supplier.name}>
    </div>
    <br>
     <div class="table-responsive">
      <textarea class="col-sm-4" rows="5" name="Address" placeholder="Address" required>${supplier.address}</textarea>
    </div>
   <br>
  <div class="table-responsive">
  <button type="submit" class="btn btn-default">Update Supplier</button>
  </div>
    </form>
     <a button class="btn btn-default"  href ="suppliertable">View Supplier Table</a> 
</div>
</body>
</html>