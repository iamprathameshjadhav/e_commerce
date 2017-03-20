<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <h1 class="well center col-sm-offset-2 col-sm-10" style=" font-family: Maiandra GD; width:900px;"><center>USER TABLE</center></h1>
<div class="col-sm-offset-2 col-sm-12">
<div class=" well col-sm-8">            
  <table class="table">
    <thead>
      <tr>
        <th>NAME</th>
         <th>EMAIL</th>
        <th>PASSWORD</th>
         <th>CONTACT</th>
          <th>ADDRESS</th>
           <th>ROLE</th>
           <th>EDIT</th>
           <th>DELETE</th>
      </tr>
    </thead>
   <tbody>
   <c:forEach items="${UserList}" var="user">
        <tr>
        
            <td>${user.name}</td>
            <td>${user.email}</td>
            <td>${user.password}</td>
            <td>${user.contact}</td>
            <td>${user.address}</td>
            <td>${user.role}</td>
             <td><a href="<c:url value='/manage_user_edit?id=${user.email}'/>" button class="btn btn-success btn-sm">Edit</a></td>
            <td><a href="<c:url value='/manage_user_remove?id=${user.email }'/>" button class="btn btn-danger btn-sm">Delete</a></td>
            </tr>
            </c:forEach>
            </tbody>   
  </table>
</div>
</div>
</body>
</html>