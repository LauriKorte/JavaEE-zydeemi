package asd.asd;

public class Ingredient {

	public int id;
	public int amount;
	public String unitName;
	public String name;
	public int ingredientUnitId;
	public int ingredientTypeId;
	public int ingredientStorageId;
	
	
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
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIngredientUnitId() {
		return ingredientUnitId;
	}
	public void setIngredientUnitId(int ingredientUnitId) {
		this.ingredientUnitId = ingredientUnitId;
	}
	public int getIngredientTypeId() {
		return ingredientTypeId;
	}
	public void setIngredientTypeId(int ingredientTypeId) {
		this.ingredientTypeId = ingredientTypeId;
	}
	public int getIngredientStorageId() {
		return ingredientStorageId;
	}
	public void setIngredientStorageId(int ingredientStorageId) {
		this.ingredientStorageId = ingredientStorageId;
	}
	
	public Ingredient(int id, int amount, String unitName, String name,
			int ingredientUnitId, int ingredientTypeId, int ingredientStorageId) {
		super();
		this.id = id;
		this.amount = amount;
		this.unitName = unitName;
		this.name = name;
		this.ingredientUnitId = ingredientUnitId;
		this.ingredientTypeId = ingredientTypeId;
		this.ingredientStorageId = ingredientStorageId;
	}
	
	public Ingredient() {
		super();
	}
	
	
	
	
}
