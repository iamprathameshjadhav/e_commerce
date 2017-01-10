<html>

<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

</head>
<body  background="<c:url value="/resources/lib/images/baground.jpg" />">
 <jsp:include page="adminnavbar.jsp" />


 <c:if test="${UserClickedCATEGORY}">
	<jsp:include page="category.jsp" />
	</c:if>
	
	<c:if test="${UserClickedSUPPLIER}">
		<jsp:include page="supplier.jsp" />
	</c:if>
   
    <c:if test="${UserClickedPRODUCT}">
		<jsp:include page="product.jsp" />
	</c:if>
	   
	 <c:if test="${UserClickedViewCategoryTable }">
		<jsp:include page="categorytable.jsp" />
	</c:if>
	
	 <c:if test="${UserClickedViewSupplierTable }">
		<jsp:include page="suppliertable.jsp" />
	</c:if>
		
		 <c:if test="${UserClickedViewProductTable }">
		 <jsp:include page="producttable.jsp" />
	</c:if>
	
	 <c:if test="${UserClickedViewManage }">
		 <jsp:include page="usertable.jsp" />
	</c:if>
	
	 <c:if test="${UserClickedEDIT }">
		 <jsp:include page="editcategory.jsp" />
	</c:if>
	<c:if test="${EditCategory }">
	<jsp:include page="editcategory.jsp" />
	</c:if>
	<c:if test="${UserclickedEDIT }">
	<jsp:include page="editsupplier.jsp" />
	</c:if>
	<c:if test="${EditSupplier }">
	<jsp:include page="editsupplier.jsp" />
	</c:if>
	<c:if test="${UserClickedEdit }">
	<jsp:include page="editusertable.jsp" />
	</c:if>
		<c:if test="${UpdateTable }">
	<jsp:include page="editusertable.jsp" />
	</c:if>
	<c:if test="${UserClickedPRODUCTEDIT }">
	<jsp:include page="editproducttable.jsp" />
	</c:if>
	<c:if test="${UserClickedUpadateProduct }">
	<jsp:include page="editproducttable.jsp" />
	</c:if>
</body>
</html>