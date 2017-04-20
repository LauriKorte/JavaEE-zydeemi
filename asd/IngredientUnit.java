package asd.asd;

public class IngredientUnit {

	public int id;
	public String name;
	public String shorthand;
	
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
