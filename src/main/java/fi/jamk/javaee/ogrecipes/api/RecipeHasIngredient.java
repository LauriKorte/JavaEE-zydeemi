package fi.jamk.javaee.ogrecipes.api;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import fi.jamk.javaee.ogrecipes.app.IdOnlyDeserializer;
import fi.jamk.javaee.ogrecipes.app.IdOnlySerializer;

@Entity(name="rcp_recipe_has_ingredient")
@Table(name="rcp_recipe_has_ingredient")
public class RecipeHasIngredient implements Serializable {
	
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int id;
		
		private int amount; 

	    @JsonSerialize(using = IdOnlySerializer.class)
		@ManyToOne(fetch=FetchType.LAZY)
		@JoinColumn(name="ingredient_id")
		private Ingredient ingredient;

	    @JsonSerialize(using = IdOnlySerializer.class)
		@ManyToOne(fetch=FetchType.LAZY)
		@JoinColumn(name="recipe_id")
		private Recipe recipe;
		
		
		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public int getAmount() {
			return amount;
		}


		public void setAmount(int amount) {
			this.amount = amount;
		}


		public Ingredient getIngredient() {
			return ingredient;
		}


		public void setIngredient(Ingredient ingredient) {
			this.ingredient = ingredient;
		}


		public Recipe getRecipe() {
			return recipe;
		}


		public void setRecipe(Recipe recipe) {
			this.recipe = recipe;
		}


		public RecipeHasIngredient(){
		}
}
