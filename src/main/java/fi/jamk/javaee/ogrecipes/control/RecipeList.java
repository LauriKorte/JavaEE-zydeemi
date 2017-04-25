package fi.jamk.javaee.ogrecipes.control;

import fi.jamk.javaee.ogrecipes.api.*;
import fi.jamk.javaee.ogrecipes.app.*;

import java.util.ArrayList;
import java.util.List;

public class RecipeList {
	private List<Recipe> recipes;
	
	public RecipeList()
	{
		recipes = new ArrayList<Recipe>();
	}
	
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
	
	public void loadRecipes(String first, String count)
	{
		
		RecipeAccess ac = new RecipeAccess();
		recipes = ac.fetchRangeRecipe(safeIntCast(first,0), safeIntCast(count,-1));
	}

	
	public List<Recipe> getRecipes() {
		return recipes;
	}
	
	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}
	
	
}
