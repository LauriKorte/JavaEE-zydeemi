package asd.asd;

public class Rating {

	public int id;
	public String description;
	public int stars;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getStars() {
		return stars;
	}
	public void setStars(int stars) {
		this.stars = stars;
	}
	
	
	public Rating(int id, String description, int stars) {
		super();
		this.id = id;
		this.description = description;
		this.stars = stars;
	}
	
	
	public Rating() {
		super();
	}
	
	
	
	
	
}

