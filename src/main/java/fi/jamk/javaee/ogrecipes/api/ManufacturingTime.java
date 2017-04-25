package fi.jamk.javaee.ogrecipes.api;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity(name="rcp_manufacturingTime")
@Table(name="rcp_manufacturingTime")
@NamedQueries({
    @NamedQuery(name="ManufacturingTime.list",
    		query="SELECT x FROM rcp_manufacturingTime x")
})
public class ManufacturingTime {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private int minimumTime;
	private int maximumTime;
	
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
