package fi.jamk.javaee.ogrecipes.control;

import fi.jamk.javaee.ogrecipes.api.*;
import fi.jamk.javaee.ogrecipes.app.*;

import java.util.ArrayList;
import java.util.List;

public class RecipeDisplay {
	private Recipe recipe;
	
	private Integer safeIntCast(String v, Integer def)
	{
		try
		{
			return Integer.parseInt(v);
		}
		catch (Exception e)
		{
			return def;
		}
	}
	
	public void loadRecipe(String id)
	{
		RecipeAccess ac = new RecipeAccess();
		recipe = ac.fetchRecipe(safeIntCast(id,-1));
	}

	
	public Recipe getRecipe() {
		return recipe;
	}
	
	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}
	
	
}
