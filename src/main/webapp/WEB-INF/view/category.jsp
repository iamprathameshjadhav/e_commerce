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
  <h2 >ADD CATEGORY</h2>
  ${message }
  <form action="addcategory" method="post">
    <div class="table-responsive">
      <input type="text" class="col-sm-4" name="ID" placeholder="ID" required>
    </div>
    <br>
  <div class="table-responsive">
      <input type="name" class="col-sm-4" name="name" placeholder="name" required>
    </div>
     <br>
     <div class="table-responsive">
      <textarea class="col-sm-4" rows="5" name="description" placeholder="Description" required></textarea>
    </div>
   <br>
   <div>
   <label class="radio-inline">
      <input type="radio" checked name="types" value="Top Wear"><b>Top Wear</b>
    </label>
    <label class="radio-inline">
      <input type="radio" name="types" value="Bottom Wear"><b>Bottom Wear</b>
    </label>
    </div>
  <br>
   <div>
   <label class="radio-inline">
      <input type="radio" checked name="gender" value="Male"><b>Male</b>
    </label>
    <label class="radio-inline">
      <input type="radio" name="gender" value="Female"><b>Female</b>
    </label>
    </div>
  <br>
  <div class="table-responsive">
  <button type="submit" class="btn btn-default">Add Category</button>
   <br>
   </div> 
 </form>
 
 <a button type="submit" class="btn btn-default"  href ="categorytable">View Category Table</a>
 

</body>
</html>