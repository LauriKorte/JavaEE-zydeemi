package fi.jamk.javaee.ogrecipes.api;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import fi.jamk.javaee.ogrecipes.app.RecipeAppContext;

public class RecipeHasIngredientPostDAO
{
	private int amount;
	private int ingredient;
	
	public RecipeHasIngredient toNewRecipeHasIngredient()
	{
		try 
		{
			EntityManager em = RecipeAppContext.createEntityManager();
			RecipeHasIngredient i = new RecipeHasIngredient();
			i.setAmount(amount);
			i.setIngredient(em.getReference(Ingredient.class, ingredient));
			em.close();
			return i;
		}
		catch (Exception e)
		{
			return null;
		}
	}
	
	
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getIngredient() {
		return ingredient;
	}
	public void setIngredient(int ingredient) {
		this.ingredient = ingredient;
	}
	
}
