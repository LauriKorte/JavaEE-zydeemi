package fi.jamk.javaee.ogrecipes.api;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;

import fi.jamk.javaee.ogrecipes.app.*;

@Entity(name = "rcp_recipeHistory")
@Table(name = "rcp_recipeHistory")
@NamedQueries({ @NamedQuery(name = "RecipeHistory.list", query = "SELECT x FROM rcp_recipeHistory x") })
public class RecipeHistory implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Date date;

	@JsonSerialize(using = IdOnlySerializer.class)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rating_id")
	private Rating rating;

	@JsonSerialize(using = IdOnlySerializer.class)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "recipe_id")
	private Recipe recipe;

	private String personalComment;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	public String getPersonalComment() {
		return personalComment;
	}

	public void setPersonalComment(String personalComment) {
		this.personalComment = personalComment;
	}

}
