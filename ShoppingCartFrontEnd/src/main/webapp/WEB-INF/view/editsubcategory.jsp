<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div class="container">
  <div class="col-sm-offset-2 col-sm-10">
   <h1 class="well center" style=" font-family: Maiandra GD; width:400px;"><center>EDIT SUBCATEGORY</center></h1>

  <form action="editsubcategory" method="post">
 <div   class="well center" style="width:400px;">
   ${Smessage }
    ${SEmessage }
    <div class="table-responsive">
      <input type="text" class="col-sm-11" name="ID" placeholder="ID" required value=${subcategory.id}>
    </div>
    <br>
  <div class="table-responsive">
      <input type="name" class="col-sm-11" name="name" placeholder="name" required value=${subcategory.name}>
    </div>
     <br>
     <div class="table-responsive">
      <textarea class="col-sm-11" rows="5" name="description" placeholder="Description" required >${subcategory.description}</textarea>
    </div>
  <br>
 <center> <button type="submit" class="col-sm-offset-0 col-sm-4 btn btn-default btn-block">Edit SubCategory</button></center>
   <br>
   </div>
 </form>
 <div class="col-sm-offset-0 col-sm-5">
 <a button type="submit" class="btn btn-success btn-block"  href ="subcategorytable">View SubCategory Table</a>
 </div>

</body>
</html>