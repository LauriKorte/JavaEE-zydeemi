package fi.jamk.javaee.ogrecipes.control;

import fi.jamk.javaee.ogrecipes.api.*;
import fi.jamk.javaee.ogrecipes.app.*;

import java.util.ArrayList;
import java.util.List;

public class RecipeHistoryList {
	private List<RecipeHistory> histories;
	
	public RecipeHistoryList()
	{
		histories = new ArrayList<RecipeHistory>();
	}
	
	private Integer safeIntCast(String v, Integer def)
	{
		try
		{
			return Integer.parseInt(v);
		}
		catch (Exception e)
		{
			return def;
		}
	}
	
	public void loadHistory(String first, String count)
	{
		RecipeAccess ac = new RecipeAccess();
		histories = ac.fetchRangeRecipeHistory(safeIntCast(first,0), safeIntCast(count,-1));
	}

	public List<RecipeHistory> getHistories() {
		return histories;
	}

	public void setHistories(List<RecipeHistory> histories) {
		this.histories = histories;
	}

	
	
	
}
