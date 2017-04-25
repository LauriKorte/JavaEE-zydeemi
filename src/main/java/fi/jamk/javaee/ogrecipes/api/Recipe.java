package fi.jamk.javaee.ogrecipes.api;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;
import fi.jamk.javaee.ogrecipes.app.*;

@Entity(name="rcp_recipe")
@Table(name="rcp_recipe")
@NamedQueries({
    @NamedQuery(name="Recipe.list",
    		query="SELECT x FROM rcp_recipe x")
})

public class Recipe implements Serializable
{

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;

    @JsonSerialize(using = IdOnlySerializer.class)
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="manufacturingTime_id")
	private ManufacturingTime manufacturingTime;

    @JsonSerialize(using = IdOnlySerializer.class)
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="amountOfAttention_id")
	private AmountOfAttention amountOfAttention;

    @JsonSerialize(using = IdOnlySerializer.class)
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="difficulty_id")
	private Difficulty difficulty;

    @JsonSerialize(using = IdOnlySerializer.class)
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="resultType_id")
	private ResultType resultType;

    @JsonSerialize(using = IdOnlySerializer.class)
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="dishType_id")
	private DishType dishType;
    
    
    @OneToMany(mappedBy="recipe", cascade = CascadeType.ALL)
	private List<RecipeHasIngredient> ingredients;
    
	private static final long serialVersionUID = 1L;
	
	

	public List<RecipeHasIngredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<RecipeHasIngredient> ingredients) {
		this.ingredients = ingredients;
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



	public ManufacturingTime getManufacturingTime() {
		return manufacturingTime;
	}



	public void setManufacturingTime(ManufacturingTime manufacturingTime) {
		this.manufacturingTime = manufacturingTime;
	}



	public AmountOfAttention getAmountOfAttention() {
		return amountOfAttention;
	}



	public void setAmountOfAttention(AmountOfAttention amountOfAttention) {
		this.amountOfAttention = amountOfAttention;
	}



	public Difficulty getDifficulty() {
		return difficulty;
	}



	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}



	public ResultType getResultType() {
		return resultType;
	}



	public void setResultType(ResultType resultType) {
		this.resultType = resultType;
	}



	public DishType getDishType() {
		return dishType;
	}



	public void setDishType(DishType dishType) {
		this.dishType = dishType;
	}



	public Recipe() {
	}
	
}
