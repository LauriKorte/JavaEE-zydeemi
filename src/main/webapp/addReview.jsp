
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
	
		<jsp:useBean id="attributes" class="fi.jamk.javaee.ogrecipes.control.AttributeList" />
		<%@ page contentType="text/html" pageEncoding="UTF-8"%>
		
		<c:set var="title" value="${display.recipe.name}" /> 
		
		<%@include file="includes/header.jspf"%>
		
		<h2>Review <c:out value="${display.recipe.name}"/></h2><br>
		
${attributes.loadAttributes()}

comment:<br> <textarea id="description"></textarea><br>

Rating: 
<select id="rating">
	<c:forEach items="${attributes.ratings}" var="i">
		<option value='${i.id}'>${i.stars} - ${i.description}</option>
	</c:forEach>
</select><br>

<button onclick="send()">Go Review, GO!!!</button>

<script>
		var halted = false;
		
		var send = function()
		{
			if (halted)
				return;
			halted = true;
			var http = new XMLHttpRequest();
			var url = "/r/recipe/RecipeHistory";
			http.open("POST", url, true);

			http.setRequestHeader("Content-type", "application/json; charset=UTF-8");

			http.onreadystatechange = function()
			{
				console.log(http.responseText);
				if(http.readyState == 4)
				{
					halted = false;
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
			
			var desc = document.getElementById("description").value;
			var rating = document.getElementById("rating").value;

			var json = 
			{"recipe":${display.recipe.id},
					"personalComment":desc,
					"rating":rating
					};

			http.send(JSON.stringify(json));
		}
</script>


	</c:otherwise>
	</c:choose>
	</c:otherwise>
	</c:choose>

