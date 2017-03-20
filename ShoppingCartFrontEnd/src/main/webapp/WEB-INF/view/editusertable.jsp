<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit User Table</title>
</head>
<body>
<div class="container">
  <h2>EDIT USER TABLE</h2>
  ${massage }
  <form action="editusertable" method="post">
    <div class="table-responsive">
      <input type="text" class="col-sm-4" name="name" placeholder="Name" required value=${user.name}>
    </div>
    <br>
  <div class="table-responsive">
      <input type="name" class="col-sm-4" name="id" placeholder="Email" required value=${user.email}>
    </div>
     <br>
      <div class="table-responsive">
      <input type="name" class="col-sm-4" name="password" placeholder="Password" required value=${user.password}>
    </div>
   <br>
    <div class="table-responsive">
      <input type="name" class="col-sm-4" name="contact" placeholder="Contact" required value=${user.contact}>
    </div>
    <br>
     <div class="table-responsive">
      <textarea class="col-sm-4" rows="5" name="address" placeholder="Address" required>${user.address}</textarea>
    </div>
    <br>
    <c:choose>
   <c:when test="${user.role=='admin'}">
   <div>
   <label class="radio-inline">
      <input type="radio" checked name="role" value="admin"><b>Admin</b>
    </label>
    <label class="radio-inline">
      <input type="radio" name="role" value="User"><b>User</b>
    </label>
    </div>
    </c:when>
   <c:otherwise>
   <div>
   <label class="radio-inline">
      <input type="radio"  name="role" value="admin"><b>Admin</b>
    </label>
    <label class="radio-inline">
      <input type="radio" checked name="role" value="User"><b>User</b>
    </label>
    </div>
   </c:otherwise>
   </c:choose>
  <br>
  <div class="table-responsive">
  <button type="submit" class="btn btn-default">Update Table</button>
   <br>
   </div> 
 </form>
 
 <a button type="submit" class="btn btn-default"  href ="usertable">View Table</a>
 

</body>
</html>