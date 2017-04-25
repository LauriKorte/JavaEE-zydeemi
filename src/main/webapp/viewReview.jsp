
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:choose>
	<c:when test="${empty param.id}" >
		<%
    	response.sendRedirect("/reviews.jsp");
		%>
	</c:when>
	<c:otherwise>
	<jsp:useBean id="display" class="fi.jamk.javaee.ogrecipes.control.RecipeHistoryDisplay" />
	${display.loadHistory(param.id)}
	<c:choose>
	<c:when	test="${empty display.history}" >
		<%
	    response.sendRedirect("/reviews.jsp");
		%>
	</c:when>
	<c:otherwise>
		<%@ page contentType="text/html" pageEncoding="UTF-8"%>
		
		<c:set var="title" value="Review on ${display.history.recipe.name}" /> 
		
		<%@include file="includes/header.jspf"%>
		
		<h2><c:out value="Review on ${display.history.recipe.name}"/></h2><br>
		
		<c:out value="${display.history.personalComment}"/><br><br>
		${display.history.rating.stars} ${display.history.rating.description}<br>
		<br>
		<a href="reviews.jsp">Goo back!!</a><br><br>
		<button onclick="deletethis()">DELETE</button>
		<script>
		
		
		
		function deletethis()
		{
			
		var http = new XMLHttpRequest();
		var url = "/r/recipe/RecipeHistory/${display.history.id}";
		http.open("DELETE", url, true);
		
		http.setRequestHeader("Content-type", "application/json; charset=UTF-8");
		
		http.onreadystatechange = function()
		{
			console.log(http.responseText);
			if(http.readyState == 4)
			{
				console.log(http.responseText);
				if (http.status == 200)
				{
					window.location.href = "reviews.jsp"
					return;
				}
				else
				{
					alert("ERRAR : " + http.status + " - " + http.responseText)
				}
				
			}
		}
		http.send("{}");
		}
		</script>
		
		
	</c:otherwise>
	</c:choose>
	</c:otherwise>
	</c:choose>
	