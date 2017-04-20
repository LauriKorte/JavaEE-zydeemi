package asd.asd;

import java.sql.Date;

public class RecipeHistory {

	public int id;
	public int recipeId;
	public Date date;
	public int rating;
	public String personalComment;
	public String recipeName;
	public String ratingName;
	public int ratingStars;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRecipeId() {
		return recipeId;
	}
	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getPersonalComment() {
		return personalComment;
	}
	public void setPersonalComment(String personalComment) {
		this.personalComment = personalComment;
	}
	public String getRecipeName() {
		return recipeName;
	}
	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}
	public String getRatingName() {
		return ratingName;
	}
	public void setRatingName(String ratingName) {
		this.ratingName = ratingName;
	}
	public int getRatingStars() {
		return ratingStars;
	}
	public void setRatingStars(int ratingStars) {
		this.ratingStars = ratingStars;
	}
	
	public RecipeHistory(int id, int recipeId, Date date, int rating,
			String personalComment, String recipeName, String ratingName,
			int ratingStars) {
		super();
		this.id = id;
		this.recipeId = recipeId;
		this.date = date;
		this.rating = rating;
		this.personalComment = personalComment;
		this.recipeName = recipeName;
		this.ratingName = ratingName;
		this.ratingStars = ratingStars;
	}
	
	public RecipeHistory() {
		super();
	}
	
	
	
	
	
	
}
