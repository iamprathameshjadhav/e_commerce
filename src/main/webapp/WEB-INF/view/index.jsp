<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

</head>
<body  background="<c:url value="/resources/lib/images/baground.jpg"/>">

	<jsp:include page="navbar.jsp" />
	
	<c:if test="${UserClickedcarousel}">
		<jsp:include page="carousel.jsp" />
	</c:if>
	
	<c:if test="${UserClickedfooter}">
		<jsp:include page="footer.jsp" />
	</c:if>


	<c:if test="${UserClickedLogin}">
		<jsp:include page="login.jsp" />
	</c:if>

	<c:if test="${UserClickedlogout}">
		<jsp:include page="index.jsp" />
	</c:if>

	<c:if test="${UserClickedRegister}">
		<jsp:include page="register.jsp" />
	</c:if>
    
	<c:if test="${UserClickedTopWearr}">
		<jsp:include page="menstopwear.jsp" />
	</c:if>

	<c:if test="${UserClickedBottomWear}">
		<jsp:include page="mensbottomwear.jsp" />
	</c:if>

	<c:if test="${UserClickedTopWear}">
		<jsp:include page="womenstopwear.jsp" />
	</c:if>

	<c:if test="${UserClickedBottomWear}">
		<jsp:include page="womensbottomwear.jsp" />
	</c:if>

	<c:if test="${UserClickedHotList}">
		<jsp:include page="thehotlist.jsp" />
	</c:if>
	
	<c:if test="${showLogin}">
		<jsp:include page="login.jsp" />
	</c:if>
		
	<c:if test="${showRegister}">
	<jsp:include page="register.jsp" />
	</c:if>
	
	<c:if test="${isUser== true}">
	<jsp:include page="homepage.jsp" />
	</c:if>
	
	<c:if test="${invalidCredentials}">
	<jsp:include page="login.jsp" />
	</c:if>
 </body>
</html>