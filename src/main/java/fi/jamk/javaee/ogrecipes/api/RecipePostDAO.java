package fi.jamk.javaee.ogrecipes.api;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import fi.jamk.javaee.ogrecipes.app.RecipeAppContext;

public class RecipePostDAO {
	
	private int id;
	
	private String name;
	private String description;

	private int manufacturingTime;
	private int amountOfAttention;
	private int difficulty;
	private int resultType;
	private int dishType;
    
	private List<RecipeHasIngredientPostDAO> ingredients;
	
	
	public Recipe toNewRecipe()
	{
		try 
		{
			EntityManager em = RecipeAppContext.createEntityManager();
			Recipe i = new Recipe();
			i.setName(name);
			i.setDescription(description);
			i.setManufacturingTime(em.getReference(ManufacturingTime.class, manufacturingTime));
			i.setAmountOfAttention(em.getReference(AmountOfAttention.class, amountOfAttention));
			i.setResultType(em.getReference(ResultType.class, resultType));
			i.setDifficulty(em.getReference(Difficulty.class, difficulty));
			i.setDishType(em.getReference(DishType.class, dishType));
			List<RecipeHasIngredient> rhi = new ArrayList<RecipeHasIngredient>();
			for (RecipeHasIngredientPostDAO ing : ingredients)
			{
				RecipeHasIngredient r = ing.toNewRecipeHasIngredient();
				r.setRecipe(i);
				rhi.add(r);
			}
			i.setIngredients(rhi);
			em.close();
			return i;
		}
		catch (Exception e)
		{
			return null;
		}
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getManufacturingTime() {
		return manufacturingTime;
	}


	public void setManufacturingTime(int manufacturingTime) {
		this.manufacturingTime = manufacturingTime;
	}


	public int getAmountOfAttention() {
		return amountOfAttention;
	}


	public void setAmountOfAttention(int amountOfAttention) {
		this.amountOfAttention = amountOfAttention;
	}


	public int getDifficulty() {
		return difficulty;
	}


	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}


	public int getResultType() {
		return resultType;
	}


	public void setResultType(int resultType) {
		this.resultType = resultType;
	}


	public int getDishType() {
		return dishType;
	}


	public void setDishType(int dishType) {
		this.dishType = dishType;
	}


	public List<RecipeHasIngredientPostDAO> getIngredients() {
		return ingredients;
	}


	public void setIngredients(List<RecipeHasIngredientPostDAO> ingredients) {
		this.ingredients = ingredients;
	}


	
}
