package fi.jamk.javaee.ogrecipes.api;
import java.util.*;
import java.sql.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;

import fi.jamk.javaee.ogrecipes.app.*;

public class RecipeHistoryPostDAO implements Serializable {

	private int rating;
	private int recipe;
	private String personalComment;
	public RecipeHistory toNewRecipeHistory()
	{
		try 
		{
			EntityManager em = RecipeAppContext.createEntityManager();
			RecipeHistory i = new RecipeHistory();
			java.util.Date d = new java.util.Date();
			i.setDate(new java.sql.Date(d.getTime()));
			i.setRating(em.getReference(Rating.class, rating));
			i.setRecipe(em.getReference(Recipe.class, recipe));
			i.setPersonalComment(personalComment);
			em.close();
			return i;
		}
		catch (Exception e)
		{
			return null;
		}
	}
	
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public int getRecipe() {
		return recipe;
	}
	public void setRecipe(int recipe) {
		this.recipe = recipe;
	}
	public String getPersonalComment() {
		return personalComment;
	}
	public void setPersonalComment(String personalComment) {
		this.personalComment = personalComment;
	}
	
	
}
