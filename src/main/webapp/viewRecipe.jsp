
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:choose>
	<c:when test="${empty param.id}" >
		<%
    	response.sendRedirect("/recipes.jsp");
		%>
	</c:when>
	<c:otherwise>
	<jsp:useBean id="display" class="fi.jamk.javaee.ogrecipes.control.RecipeDisplay" />
	${display.loadRecipe(param.id)}
	<c:choose>
	<c:when	test="${empty display.recipe}" >
		<%
	    response.sendRedirect("/recipes.jsp");
		%>
	</c:when>
	<c:otherwise>
		<%@ page contentType="text/html" pageEncoding="UTF-8"%>
		
		<c:set var="title" value="${display.recipe.name}" /> 
		
		<%@include file="includes/header.jspf"%>
		
		<h2><c:out value="${display.recipe.name}"/></h2><br>
		
		<c:out value="${display.recipe.description}"/><br>
		<table cellpadding="4">
		<tr><td>Attention required</td><td> ${display.recipe.amountOfAttention.name}</td></tr>
		<tr><td>Difficulty:</td><td> ${display.recipe.difficulty.name}</td></tr>
		<tr><td>Dish type:</td><td> ${display.recipe.dishType.name}</td></tr>
		<tr><td>Result:</td><td> ${display.recipe.resultType.name}</td></tr>
		<tr><td>Estimated time</td><td> ${display.recipe.manufacturingTime.name} ${display.recipe.manufacturingTime.minimumTime}-${display.recipe.manufacturingTime.maximumTime} min</td></tr>
		</table>
		
		<table style="border: 1px solid;" cellpadding="4">
			<c:forEach items="${display.recipe.ingredients}" var="ing">
				<tr><td>${ing.amount} ${ing.ingredient.ingredientUnit.shorthand}</td><td>${ing.ingredient.name}</td></tr>
			</c:forEach>
		</table>
		<br>
		<a href="addReview.jsp?id=${display.recipe.id}" >Review this cereation!1</a>
		<br>
		<br>
		<button onclick="deletethis()">DELETE</button>
		<script>
		
		
		
		function deletethis()
		{
			
		var http = new XMLHttpRequest();
		var url = "/r/recipe/Recipe/${display.recipe.id}";
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
					window.location.href = "recipes.jsp"
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
	