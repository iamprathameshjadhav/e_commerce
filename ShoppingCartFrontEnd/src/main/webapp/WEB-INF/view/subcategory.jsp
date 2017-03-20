<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>add subcategory</title>
</head>
<div class="col-sm-offset-2 col-sm-10">
   <h1 class="well center" style=" font-family: Maiandra GD; width:400px;"><center>ADD SUBCATEGORY</center></h1>

  <form action="addsubcategory" method="post">
  <div class="well" style="width:400px;">
    ${Smessage }
    ${SEmessage }
    <div class="table-responsive">
     <center><input type="text" class="col-sm-11" name="ID" placeholder="ID" required></center>
    </div>
    <br>
  <div class="table-responsive">
      <input type="name" class="col-sm-11" name="name" placeholder="name" required>
    </div>
     <br>
     <div class="table-responsive">
      <textarea class="col-sm-11" rows="5" name="description" placeholder="Description" required></textarea>
    </div>
  <br>
  <div class="table-responsive">
  <button type="submit" class="btn btn-default btn-block">Add SubCategory</button>
   </div>
   </div> 
 </form>
 <div class="col-sm-offset-0 col-sm-4">
<a button type="submit" class="btn btn-success btn-block"  href ="subcategorytable" style="margin-bottom:40px; margin-top:-10px;">View SubCategory Table</a>
</div>
</div>
</body>
</html>