<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="title" value="reviews" /> 
<%@include file="includes/header.jspf"%>


<jsp:useBean id="reviewList" class="fi.jamk.javaee.ogrecipes.control.RecipeHistoryList" />

${reviewList.loadHistory(param["from"],"-1")}

<table class="w3-red w3-table w3-hoverable w3-bordered">
	<c:forEach items="${reviewList.histories}"  var="rev">
		<tr><td><a href="viewReview.jsp?id=${rev.id}" > <c:out value="${rev.recipe.name}" /> <c:out value="${rev.date}" /></a></td></tr>
	</c:forEach>
</table>