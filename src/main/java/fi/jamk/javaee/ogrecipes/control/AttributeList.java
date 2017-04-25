package fi.jamk.javaee.ogrecipes.control;

import fi.jamk.javaee.ogrecipes.api.*;
import fi.jamk.javaee.ogrecipes.app.*;

import java.util.ArrayList;
import java.util.List;

public class AttributeList {
	private List<Rating> ratings;
	private List<AmountOfAttention> amountOfAttentions;
	private List<DishType> dishTypes;
	private List<ManufacturingTime> manufacturingTimes;
	private List<Difficulty> difficulties;
	private List<ResultType> resultTypes;
	
	public AttributeList()
	{
		ratings = new ArrayList<Rating>();
		amountOfAttentions = new ArrayList<AmountOfAttention>();
		dishTypes = new ArrayList<DishType>();
		manufacturingTimes = new ArrayList<ManufacturingTime>();
		difficulties = new ArrayList<Difficulty>();
		resultTypes = new ArrayList<ResultType>();
	}

	
	public void loadAttributes()
	{
		RecipeAccess ac = new RecipeAccess();

		ratings = ac.fetchAllRating();
		amountOfAttentions = ac.fetchAllAmountOfAttention();
		dishTypes = ac.fetchAllDishType();
		manufacturingTimes = ac.fetchAllManufacturingTime();
		difficulties = ac.fetchAllDifficulty();
		resultTypes = ac.fetchAllResultType();
	}


	public List<Rating> getRatings() {
		return ratings;
	}


	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}


	public List<AmountOfAttention> getAmountOfAttentions() {
		return amountOfAttentions;
	}


	public List<DishType> getDishTypes() {
		return dishTypes;
	}


	public List<ManufacturingTime> getManufacturingTimes() {
		return manufacturingTimes;
	}


	public List<Difficulty> getDifficulties() {
		return difficulties;
	}


	public List<ResultType> getResultTypes() {
		return resultTypes;
	}


	
	
}
