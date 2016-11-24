<html>
<head>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>

</head>
<body>

<jsp:include page="navbar.jsp" />


<c:if test= "${UserClickedLogin}">
<jsp:include page="login.jsp" />
</c:if>

<c:if test= "${UserClickedRegister}">
<jsp:include page="register.jsp" />
</c:if>

</body>
</html>