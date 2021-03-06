<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

</head>
 <body  <%-- background="<c:url value="/resources/lib/images/baground.jpg"/>" --%>>

	<jsp:include page="navbar.jsp" />
	
	
	<c:if test="${UserClickedaboutus}">
		<jsp:include page="aboutus.jsp" />
	</c:if>
	
	<c:if test="${Param =='SearchResult'}">
			<%@include file="searchResult.jsp"%> 
			
		</c:if>
		
	<c:if test="${!empty selectedProduct.name}">
	<%@ include file="selectedProduct.jsp" %>
	</c:if>
	
	<c:if test="${UserClickedCart}">
		<jsp:include page="carttable.jsp" />
	</c:if>

	
	<c:if test="${UserClickedfooter}">
		<jsp:include page="footer.jsp" />
	</c:if>

<c:if test="${UserClickedAboutUs}">
		<jsp:include page="aboutus.jsp" />
	</c:if>

	<c:if test="${UserClickedLogin}">
		<jsp:include page="login.jsp" />
	</c:if>

	<c:if test="${UserClickedlogout}">
		<jsp:include page="homepage.jsp" />
	</c:if>

	<c:if test="${UserClickedRegister}">
		<jsp:include page="register.jsp" />
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
	
	<c:if test="${productListLoaded}">
	<jsp:include page="productdisplay.jsp" />
	</c:if>
	
 </body>
 <jsp:include page="footer.jsp" />
</html>