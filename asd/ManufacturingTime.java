package asd.asd;

public class ManufacturingTime {

	public int id;
	public String name;
	public int minimumTime;
	public int maximumTime;
	
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
	public int getMinimumTime() {
		return minimumTime;
	}
	public void setMinimumTime(int minimumTime) {
		this.minimumTime = minimumTime;
	}
	public int getMaximumTime() {
		return maximumTime;
	}
	public void setMaximumTime(int maximumTime) {
		this.maximumTime = maximumTime;
	}
	
	public ManufacturingTime(int id, String name, int minimumTime,
			int maximumTime) {
		super();
		this.id = id;
		this.name = name;
		this.minimumTime = minimumTime;
		this.maximumTime = maximumTime;
	}
	
	public ManufacturingTime() {
		super();
	}
	
	
	
	
}
