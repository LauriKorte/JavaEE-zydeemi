package fi.jamk.javaee.ogrecipes.control;

import fi.jamk.javaee.ogrecipes.api.*;
import fi.jamk.javaee.ogrecipes.app.*;

import java.util.ArrayList;
import java.util.List;

public class IngredientList {
	private List<Ingredient> ingredients;
	
	public IngredientList()
	{
		ingredients = new ArrayList<Ingredient>();
	}
	
	public void loadIngredients()
	{
		RecipeAccess ac = new RecipeAccess();
		ingredients = ac.fetchAllIngredient();
	}

	
	public List<Ingredient> getIngredients() {
		return ingredients;
	}
	
	
}
