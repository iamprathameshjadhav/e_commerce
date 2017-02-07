<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html> 
<html>
<head>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
</head>

<body>
<jsp:include page="navbar.jsp" />
<div class="container">
 <div class="row">
 <div class="col-xs-6 col-md-6">
 <br><br><br><br><br>
 </div>
 <div class="col-xs-6 col-md-5">
    <br><br><br><br><br><br><br><br><br><br>
     <i><h3>  Your order is confirmed.</h3>
      <p> <h3> BUT YOU PLAYED YOURSELF  </h3>
       <p> <h1>NO ONE IS GOING TO SEND ANY CLOTHES TO YOUR HOME</h1></i><br>
      <form:form action="${flowExecutionUrl}&_eventId=finalIndex"><input type= "submit" value="Continue Shopping"   class="btn btn-md btn-success"/></form:form>
     </div>
    </div>
  </div>
 
</body>
</html>