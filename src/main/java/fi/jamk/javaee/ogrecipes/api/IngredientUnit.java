package fi.jamk.javaee.ogrecipes.api;

import java.io.Serializable;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="rcp_ingredientUnit")
@Table(name="rcp_ingredientUnit")
public class IngredientUnit {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String shorthand;
	
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
	public String getShorthand() {
		return shorthand;
	}
	public void setShorthand(String shorthand) {
		this.shorthand = shorthand;
	}
	
	public IngredientUnit(int id, String name, String shorthand) {
		super();
		this.id = id;
		this.name = name;
		this.shorthand = shorthand;
	}
	
	
	public IngredientUnit() {
		super();
	}
	
	
	
	
	
	
}
