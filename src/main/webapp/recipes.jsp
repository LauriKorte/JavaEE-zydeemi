<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="title" value="recipes" /> 
<%@include file="includes/header.jspf"%>


<jsp:useBean id="recipeList" class="fi.jamk.javaee.ogrecipes.control.RecipeList" />

${recipeList.loadRecipes(param["from"],"-1")}

<table class="w3-centered w3-table w3-hoverable w3-bordered">
	<c:forEach items="${recipeList.recipes}"  var="recipe">
		<tr><td><a href="viewRecipe.jsp?id=${recipe.id}" value="<c:out value="${recipe.name}"/>" > <c:out value="${recipe.name}" /></a></td></tr>
	</c:forEach>
</table>