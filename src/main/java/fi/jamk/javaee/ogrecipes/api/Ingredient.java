package fi.jamk.javaee.ogrecipes.api;

import java.io.IOException;
import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import fi.jamk.javaee.ogrecipes.app.IdOnlyDeserializer;
import fi.jamk.javaee.ogrecipes.app.IdOnlySerializer;
import fi.jamk.javaee.ogrecipes.app.RecipeAppContext;

@Entity(name="rcp_ingredient")
@Table(name="rcp_ingredient")
public class Ingredient {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;

    @JsonSerialize(using = IdOnlySerializer.class)
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ingredientUnit_id")
	private IngredientUnit ingredientUnit;
    
    @JsonSerialize(using = IdOnlySerializer.class)
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ingredientType_id")
	private IngredientType ingredientType;

    @JsonSerialize(using = IdOnlySerializer.class)
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ingredientStorage_id")
	private IngredientStorage ingredientStorage;
	
	
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


	public IngredientUnit getIngredientUnit() {
		return ingredientUnit;
	}


	public void setIngredientUnit(IngredientUnit ingredientUnit) {
		this.ingredientUnit = ingredientUnit;
	}


	public IngredientType getIngredientType() {
		return ingredientType;
	}


	public void setIngredientType(IngredientType ingredientType) {
		this.ingredientType = ingredientType;
	}


	public IngredientStorage getIngredientStorage() {
		return ingredientStorage;
	}


	public void setIngredientStorage(IngredientStorage ingredientStorage) {
		this.ingredientStorage = ingredientStorage;
	}


	public Ingredient() {
		super();
	}
	
	
	
	
}
