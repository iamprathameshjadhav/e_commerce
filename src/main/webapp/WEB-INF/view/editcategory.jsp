<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Category</title>
</head>
<body>

<div class="container">
  <h2>EDIT CATEGORY</h2>
  ${message }
  <form action="editcategory" method="post">
    <div class="table-responsive">
      <input type="text" class="col-sm-4" name="ID" placeholder="ID" required value=${category.category_id}>
    </div>
    <br>
  <div class="table-responsive">
      <input type="name" class="col-sm-4" name="name" placeholder="name" required value=${category.name}>
    </div>
     <br>
     <div class="table-responsive">
      <textarea class="col-sm-4" rows="5" name="description" placeholder="Description" required >${category.description}</textarea>
    </div>
   <br>
   <c:choose>
   <c:when test="${category.types=='Top Wear'}">
   <div> 
     <label class="radio-inline">
      <input type="radio" checked name="types" value="Top Wear"><b>Top Wear</b>
    </label>
    <label class="radio-inline">
      <input type="radio" name="types" value="Bottom Wear"><b>Bottom Wear</b>
    </label>
    </div>
    </c:when>
    <c:otherwise>
    <div>
     <label class="radio-inline">
      <input type="radio"  name="types" value="Top Wear"><b>Top Wear</b>
    </label>
    <label class="radio-inline">
      <input type="radio" checked name="types" value="Bottom Wear"><b>Bottom Wear</b>
    </label>
    </div>
    </c:otherwise>
    </c:choose>
  <br>
   <c:choose>
   <c:when test="${category.gender=='Male'}">
   <div>
   <label class="radio-inline">
      <input type="radio" checked name="gender" value="Male"><b>Male</b>
    </label>
    <label class="radio-inline">
      <input type="radio" name="gender" value="Female"><b>Female</b>
    </label>
    </div>
    </c:when>
    <c:otherwise>
     <div>
   <label class="radio-inline">
      <input type="radio" name="gender" value="Male"><b>Male</b>
    </label>
    <label class="radio-inline">
      <input type="radio"  checked name="gender" value="Female"><b>Female</b>
    </label>
    </div>
    </c:otherwise>
    </c:choose>
  <br>
  <div class="table-responsive">
  <button type="submit" class="btn btn-default">Edit Category</button>
   <br>
   </div>
 </form>
 
 <a button type="submit" class="btn btn-default"  href ="categorytable">View Category Table</a>
 

</body>
</html>