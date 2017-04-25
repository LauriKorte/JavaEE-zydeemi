package fi.jamk.javaee.ogrecipes.api;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;

import fi.jamk.javaee.ogrecipes.app.RecipeAppContext;

public class IngredientPostDAO {
	
	private String name;
	private int ingredientUnit;
	private int ingredientType;
	private int ingredientStorage;
	
	public Ingredient toNewIngredient()
	{
		try 
		{
			EntityManager em = RecipeAppContext.createEntityManager();
			Ingredient i = new Ingredient();
			i.setIngredientStorage(em.getReference(IngredientStorage.class, ingredientStorage));
			i.setIngredientType(em.getReference(IngredientType.class, ingredientType));
			i.setIngredientUnit(em.getReference(IngredientUnit.class, ingredientUnit));
			em.close();
			return i;
		}
		catch (Exception e)
		{
			return null;
		}
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getIngredientUnit() {
		return ingredientUnit;
	}


	public void setIngredientUnit(int ingredientUnit) {
		this.ingredientUnit = ingredientUnit;
	}


	public int getIngredientType() {
		return ingredientType;
	}


	public void setIngredientType(int ingredientType) {
		this.ingredientType = ingredientType;
	}


	public int getIngredientStorage() {
		return ingredientStorage;
	}


	public void setIngredientStorage(int ingredientStorage) {
		this.ingredientStorage = ingredientStorage;
	}


	public IngredientPostDAO() {
		super();
	}
	
	
	
	
}
