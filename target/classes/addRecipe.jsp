
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="title" value="addin' recipes" /> 
<%@include file="includes/header.jspf"%>
<jsp:useBean id="attributes" class="fi.jamk.javaee.ogrecipes.control.AttributeList" />
<jsp:useBean id="ingList" class="fi.jamk.javaee.ogrecipes.control.IngredientList" />

${attributes.loadAttributes()}
${ingList.loadIngredients()}
Name:<input type="text" id="name"><br>
Description:<br> <textarea id="description"></textarea><br>
Dishtype: <select id="dishType">
	<c:forEach items="${attributes.dishTypes}" var="i">
		<option value='${i.id}'>${i.name}</option>
	</c:forEach>
</select><br>
Aoa: <select id="amountOfAttention">
	<c:forEach items="${attributes.amountOfAttentions}" var="i">
		<option value='${i.id}'>${i.name}</option>
	</c:forEach>
</select><br>
diff: <select id="difficulty">
	<c:forEach items="${attributes.difficulties}" var="i">
		<option value='${i.id}'>${i.name}</option>
	</c:forEach>
</select><br>
mtime: <select id="manufacturingTime">
	<c:forEach items="${attributes.manufacturingTimes}" var="i">
		<option value='${i.id}'>${i.name}  ${i.minimumTime} - ${i.maximumTime} minutes</option>
	</c:forEach>
</select><br>
resultype: <select id="resultType">
	<c:forEach items="${attributes.resultTypes}" var="i">
		<option value='${i.id}'>${i.name}</option>
	</c:forEach>
</select><br>
		<div id="ingList">
		</div>
		<br>
		Recipe:
		<br>
		<div id="targetList">
		</div>
		<span style="display: none" id="totallynothax">[<c:forEach items="${ingList.ingredients}" var="i">{"name": "${i.name}", "unit": "${i.ingredientUnit.name}", "id": ${i.id} },</c:forEach>{"id":-1}]</span>

<button onclick="send()">Go Repice, GO!!!</button>

<script>
		var halted = false;
		var ings = JSON.parse(document.getElementById("totallynothax").innerHTML);
		var tarings = {};
		var ilist = document.getElementById("ingList");
		var tlist = document.getElementById("targetList");
		var addToT = function(ing, amt)
		{
			let tli = document.createElement("button");
			tli.type = "button";
			tli.className = "btn btn-warning";
			ing.tli = tli;
			tli.innerHTML = ing.name+" "+amt+" "+ing.unit;
			tlist.appendChild(tli);
			tarings[ing.id] = amt;
			
			tli.onclick = function()
			{
				tlist.removeChild(tli);
				ing.li.style.display = "";
				delete tarings[ing.id];
			}
		}
		for (var i = 0; i < ings.length; i++)
		{
			
			let ouring = ings[i];
			if (ouring.id < 0)
				continue
			let li = document.createElement("button");
			li.type = "button";
			li.className = "";
			ouring.li = li;	
			li.innerHTML = ouring.name;
			li.onclick = function()
			{
				var amt = window.prompt("How much "+ouring.name+" ("+ouring.unit+")","1");
				var num = Number(amt);
				if (isNaN(num))
					return;
				li.style.display = "none";
				addToT(ouring, amt);
				
			};
			ilist.appendChild(li);
		}
		
		var send = function()
		{
			if (halted)
				return;
			halted = true;
			var http = new XMLHttpRequest();
			var url = "/r/recipe/Recipe";
			http.open("POST", url, true);

			http.setRequestHeader("Content-type", "application/json; charset=UTF-8");

			http.onreadystatechange = function()
			{
				if(http.readyState == 4)
				{
					halted = false;
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
			var name = document.getElementById("name").value;
			var desc = document.getElementById("description").value;
			var mtime = document.getElementById("manufacturingTime").value;
			var aoa = document.getElementById("amountOfAttention").value;
			var diff = document.getElementById("difficulty").value;
			var rtype = document.getElementById("resultType").value;
			var dtype = document.getElementById("dishType").value;

			var json = 
			{"name":name,"description":desc,"ingredients":
				toLidArray(),
				"manufacturingTime":mtime,
				"amountOfAttention":aoa,
				"difficulty":diff,
				"resultType":rtype,
				"dishType":dtype};

			http.send(JSON.stringify(json));
		}
		var toLidArray = function()
		{
			var lid = [];
			for (var ingid in tarings)
			{
				if (!tarings.hasOwnProperty(ingid))
					continue;
				lid.push({ingredient: ingid, amount: tarings[ingid]});
			}
			return lid;
		}
</script>
