<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.1/jquery.min.js"></script>
</head>
<body>

<div class="container">
  <h2>ADD SUPPLIER</h2>
    ${message }
  <form action="addsupplier" method="post">
    <div class="table-responsive">
      <input type="text" class="col-sm-4" name="ID" placeholder="ID" required>
    </div>
    <br>
  <div class="table-responsive">
      <input type="name" class="col-sm-4" name="name" placeholder="Name" required>
    </div>
    <br>
     <div class="table-responsive">
      <textarea class="col-sm-4" rows="5" name="Address" placeholder="Address" required></textarea>
    </div>
   <br>
  <div class="table-responsive">
  <button type="submit" class="btn btn-default">Add Supplier</button>
  </div>
    </form>
     <a button class="btn btn-default"  href ="suppliertable">View Supplier Table</a> 
</div>
</body>
</html>