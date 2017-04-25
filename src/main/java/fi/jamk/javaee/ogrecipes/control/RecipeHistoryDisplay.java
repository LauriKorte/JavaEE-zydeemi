package fi.jamk.javaee.ogrecipes.control;

import fi.jamk.javaee.ogrecipes.api.*;
import fi.jamk.javaee.ogrecipes.app.*;

import java.util.ArrayList;
import java.util.List;

public class RecipeHistoryDisplay {
	private RecipeHistory history;
	
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
	
	public void loadHistory(String id)
	{
		RecipeAccess ac = new RecipeAccess();
		history = ac.fetchRecipeHistory(safeIntCast(id,-1));
	}

	public RecipeHistory getHistory() {
		return history;
	}

	public void setHistory(RecipeHistory history) {
		this.history = history;
	}

	
	
	
}
