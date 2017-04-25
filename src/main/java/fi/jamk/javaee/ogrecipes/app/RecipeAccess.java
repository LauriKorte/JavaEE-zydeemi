package fi.jamk.javaee.ogrecipes.app;
import fi.jamk.javaee.ogrecipes.auth.*;
import fi.jamk.javaee.ogrecipes.api.*;

import java.sql.*;
import javax.persistence.*;
import javax.persistence.criteria.*;
import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fi.jamk.javaee.ogrecipes.api.Recipe;
import fi.jamk.javaee.ogrecipes.api.RecipeHasIngredient;
import fi.jamk.javaee.ogrecipes.auth.Authenticator;

@Path("/recipe")
public class RecipeAccess {
	
	public Object genericFetch(Class<?> cl, Integer id) {

        try
        {
        	EntityManager em = RecipeAppContext.createEntityManager();

 			Object obj = em.getReference(cl, id);
       
 	        em.close();
            return obj;

        } catch (Exception ex) {
        	ex.printStackTrace();
        }
        return null;
	}
	
	public <T> List<T> genericFetchAll(Class<T> cl)
	{
		return genericFetchRange(cl,0,-1);
	}
	
	public <T> List<T> genericFetchRange(Class<T> cl, int firstResult , int resultCount)
	{
		try
		{
			EntityManager em = RecipeAppContext.createEntityManager();
			CriteriaBuilder cb = em.getCriteriaBuilder();
			 
			CriteriaQuery<T> q = cb.createQuery(cl);
			Root<T> c = q.from(cl);
			q.select(c);
			
			TypedQuery<T> query = em.createQuery(q);

			if (firstResult >= 0)
				query.setFirstResult(firstResult);
			if (resultCount >= 0)
				query.setMaxResults(resultCount);
			
			List<T> results = query.getResultList();
			return results;
		}
		catch (Exception ex)
		{
        	ex.printStackTrace();
        }
        return new ArrayList<T>();
	}
	
	@GET
	@Path("/IngredientUnit")
	@Produces("application/json; charset=UTF-8")
	public List<IngredientUnit> fetchAllIngredientUnit() {
		
        return genericFetchAll(IngredientUnit.class);
	}
	
	@GET
	@Path("/IngredientStorage")
	@Produces("application/json; charset=UTF-8")
	public List<IngredientStorage> fetchAllIngredientStorage() {
		
        return genericFetchAll(IngredientStorage.class);
	}
	
	@GET
	@Path("/IngredientType")
	@Produces("application/json; charset=UTF-8")
	public List<IngredientType> fetchAllIngredientType() {
		
        return genericFetchAll(IngredientType.class);
	}
	@GET
	@Path("/ManufacturingTime")
	@Produces("application/json; charset=UTF-8")
	public List<ManufacturingTime> fetchAllManufacturingTime() {
		
        return genericFetchAll(ManufacturingTime.class);
	}
	@GET
	@Path("/ResultType")
	@Produces("application/json; charset=UTF-8")
	public List<ResultType> fetchAllResultType() {
		
        return genericFetchAll(ResultType.class);
	}
	@GET
	@Path("/Difficulty")
	@Produces("application/json; charset=UTF-8")
	public List<Difficulty> fetchAllDifficulty() {
		
        return genericFetchAll(Difficulty.class);
	}
	@GET
	@Path("/DishType")
	@Produces("application/json; charset=UTF-8")
	public List<DishType> fetchAllDishType() {
		
        return genericFetchAll(DishType.class);
	}
	@GET
	@Path("/Ingredient")
	@Produces("application/json; charset=UTF-8")
	public List<Ingredient> fetchAllIngredient() {
		
        return genericFetchAll(Ingredient.class);
	}
	@GET
	@Path("/Recipe")
	@Produces("application/json; charset=UTF-8")
	public List<Recipe> fetchAllRecipe() {
		
        return genericFetchAll(Recipe.class);
	}
	@GET
	@Path("/AmountOfAttention")
	@Produces("application/json; charset=UTF-8")
	public List<AmountOfAttention> fetchAllAmountOfAttention() {
		
        return genericFetchAll(AmountOfAttention.class);
	}
	
	@GET
	@Path("/RecipeHistory")
	@Produces("application/json; charset=UTF-8")
	public List<RecipeHistory> fetchAllRecipeHistory() {
		
        return genericFetchAll(RecipeHistory.class);
	}
	@GET
	@Path("/Rating")
	@Produces("application/json; charset=UTF-8")
	public List<Rating> fetchAllRating() {
		
        return genericFetchAll(Rating.class);
	}
	
	
	//Ranged queries
	final private static String rangeExprPath = "/{first}:{max}";
	
	@GET
	@Path("/IngredientUnit"+rangeExprPath)
	@Produces("application/json; charset=UTF-8")
	public List<IngredientUnit> fetchRangeIngredientUnit(@PathParam("first") Integer first, @PathParam("max") Integer max) {
		
        return genericFetchRange(IngredientUnit.class, first, max);
	}
	
	@GET
	@Path("/IngredientStorage"+rangeExprPath)
	@Produces("application/json; charset=UTF-8")
	public List<IngredientStorage> fetchRangeIngredientStorage(@PathParam("first") Integer first, @PathParam("max") Integer max) {
		
        return genericFetchRange(IngredientStorage.class, first, max);
	}
	
	@GET
	@Path("/IngredientType"+rangeExprPath)
	@Produces("application/json; charset=UTF-8")
	public List<IngredientType> fetchRangeIngredientType(@PathParam("first") Integer first, @PathParam("max") Integer max) {
		
        return genericFetchRange(IngredientType.class, first, max);
	}
	@GET
	@Path("/ManufacturingTime"+rangeExprPath)
	@Produces("application/json; charset=UTF-8")
	public List<ManufacturingTime> fetchRangeManufacturingTime(@PathParam("first") Integer first, @PathParam("max") Integer max) {
		
        return genericFetchRange(ManufacturingTime.class, first, max);
	}
	@GET
	@Path("/ResultType"+rangeExprPath)
	@Produces("application/json; charset=UTF-8")
	public List<ResultType> fetchRangeResultType(@PathParam("first") Integer first, @PathParam("max") Integer max) {
		
        return genericFetchRange(ResultType.class, first, max);
	}
	@GET
	@Path("/Difficulty"+rangeExprPath)
	@Produces("application/json; charset=UTF-8")
	public List<Difficulty> fetchRangeDifficulty(@PathParam("first") Integer first, @PathParam("max") Integer max) {
		
        return genericFetchRange(Difficulty.class, first, max);
	}
	@GET
	@Path("/DishType"+rangeExprPath)
	@Produces("application/json; charset=UTF-8")
	public List<DishType> fetchRangeDishType(@PathParam("first") Integer first, @PathParam("max") Integer max) {
		
        return genericFetchRange(DishType.class, first, max);
	}
	@GET
	@Path("/Ingredient"+rangeExprPath)
	@Produces("application/json; charset=UTF-8")
	public List<Ingredient> fetchRangeIngredient(@PathParam("first") Integer first, @PathParam("max") Integer max) {
		
        return genericFetchRange(Ingredient.class, first, max);
	}
	@GET
	@Path("/Recipe"+rangeExprPath)
	@Produces("application/json; charset=UTF-8")
	public List<Recipe> fetchRangeRecipe(@PathParam("first") Integer first, @PathParam("max") Integer max) {
		
        return genericFetchRange(Recipe.class, first, max);
	}
	@GET
	@Path("/AmountOfAttention"+rangeExprPath)
	@Produces("application/json; charset=UTF-8")
	public List<AmountOfAttention> fetchRangeAmountOfAttention(@PathParam("first") Integer first, @PathParam("max") Integer max) {
		
        return genericFetchRange(AmountOfAttention.class, first, max);
	}
	
	@GET
	@Path("/RecipeHistory"+rangeExprPath)
	@Produces("application/json; charset=UTF-8")
	public List<RecipeHistory> fetchRangeRecipeHistory(@PathParam("first") Integer first, @PathParam("max") Integer max) {
		
        return genericFetchRange(RecipeHistory.class, first, max);
	}
	@GET
	@Path("/Rating"+rangeExprPath)
	@Produces("application/json; charset=UTF-8")
	public List<Rating> fetchRangeRating(@PathParam("first") Integer first, @PathParam("max") Integer max) {
		
        return genericFetchRange(Rating.class, first, max);
	}
	
	//Single queries
	
	@GET
	@Path("/IngredientUnit/{id}")
	@Produces("application/json; charset=UTF-8")
	public IngredientUnit fetchIngredientUnit(@PathParam("id") Integer id) {
		
        return (IngredientUnit)genericFetch(IngredientUnit.class, id);
	}
	
	
	
	
	@GET
	@Path("/IngredientStorage/{id}")
	@Produces("application/json; charset=UTF-8")
	public IngredientStorage fetchIngredientStorage(@PathParam("id") Integer id) {
		
        return (IngredientStorage)genericFetch(IngredientStorage.class, id);
	}
	
	
	
	@GET
	@Path("/IngredientType/{id}")
	@Produces("application/json; charset=UTF-8")
	public IngredientType fetchIngredientType(@PathParam("id") Integer id) {
		
        return (IngredientType)genericFetch(IngredientType.class, id);
	}
	
	@GET
	@Path("/Recipe/{id}")
	@Produces("application/json; charset=UTF-8")
	public Recipe fetchRecipe(@PathParam("id") Integer id) {
		
        return (Recipe)genericFetch(Recipe.class, id);
	}
	

	@GET
	@Path("/DishType/{id}")
	@Produces("application/json; charset=UTF-8")
	public DishType fetchDishType(@PathParam("id") Integer id) {
		
        return (DishType)genericFetch(DishType.class, id);
	}
	
	@GET
	@Path("/Difficulty/{id}")
	@Produces("application/json; charset=UTF-8")
	public Difficulty fetchDifficulty(@PathParam("id") Integer id) {
		
        return (Difficulty)genericFetch(Difficulty.class, id);
	}
	
	@GET
	@Path("/ManufacturingTime/{id}")
	@Produces("application/json; charset=UTF-8")
	public ManufacturingTime fetchManufacturingTime(@PathParam("id") Integer id) {
		
        return (ManufacturingTime)genericFetch(ManufacturingTime.class, id);
	}
	
	@GET
	@Path("/ResultType/{id}")
	@Produces("application/json; charset=UTF-8")
	public ResultType fetchResultType(@PathParam("id") Integer id) {
		
        return (ResultType)genericFetch(ResultType.class, id);
	}
	
	@GET
	@Path("/Ingredient/{id}")
	@Produces("application/json; charset=UTF-8")
	public Ingredient fetchIngredient(@PathParam("id") Integer id) {
        return (Ingredient)genericFetch(Ingredient.class, id);
	}
	
	
	@GET
	@Path("/RecipeHistory/{id}")
	@Produces("application/json; charset=UTF-8")
	public RecipeHistory fetchRecipeHistory(@PathParam("id") Integer id) {
		
        return (RecipeHistory)genericFetch(RecipeHistory.class, id);
	}
	
	@GET
	@Path("/Rating/{id}")
	@Produces("application/json; charset=UTF-8")
	public Rating fetchRating(@PathParam("id") Integer id) {
        return (Rating)genericFetch(Rating.class, id);
	}
	
	
	
	@POST
	@Path("/RecipeHistory")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public RecipeHistory postRecipeHistory(@Context HttpServletRequest request, RecipeHistoryPostDAO input) {
		if (Authenticator.Authenticate(request, AuthenticationLevel.USER_EDIT_INGREDIENT))
		{

			EntityManager em;
			try {
				em = RecipeAppContext.createEntityManager();
		

				RecipeHistory r = input.toNewRecipeHistory();
				
		        EntityTransaction tran = em.getTransaction();	        
		        tran.begin();
				em.persist(r);
				tran.commit();
				
				em.close();
				return r;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		throw new NotAuthorizedException("User must be authorized");
	}
	
	@POST
	@Path("/Ingredient")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Ingredient postIngredient(@Context HttpServletRequest request, IngredientPostDAO input) {
		if (Authenticator.Authenticate(request, AuthenticationLevel.USER_EDIT_INGREDIENT))
		{
			Ingredient i = input.toNewIngredient();
			return i;
		}
		throw new NotAuthorizedException("User must be authorized");
	}
	
	
	@POST
	@Path("/Recipe")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Recipe postRecipe(@Context HttpServletRequest request, RecipePostDAO input) {
		if (Authenticator.Authenticate(request, AuthenticationLevel.USER_EDIT_INGREDIENT))
		{
			EntityManager em;
			try {
				em = RecipeAppContext.createEntityManager();
		
				Recipe r = input.toNewRecipe();

		        EntityTransaction tran = em.getTransaction();	        
		        tran.begin();
				em.persist(r);
				tran.commit();
				
				em.close();
				return r;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		throw new NotAuthorizedException("User must be authorized");
	}
	
	
	@DELETE
	@Path("/RecipeHistory/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public boolean deleteRecipeHistory(@Context HttpServletRequest request, @PathParam("id") Integer id) {
		if (Authenticator.Authenticate(request, AuthenticationLevel.USER_EDIT_INGREDIENT))
		{
			EntityManager em;
			try {
				em = RecipeAppContext.createEntityManager();

		        EntityTransaction tran = em.getTransaction();	
		        
		        
		        tran.begin();
		        em.remove(em.getReference(RecipeHistory.class, id));
				tran.commit();
				
				em.close();
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		throw new NotAuthorizedException("User must be authorized");
	}
	
	@DELETE
	@Path("/Recipe/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public boolean deleteRecipe(@Context HttpServletRequest request, @PathParam("id") Integer id) {
		if (Authenticator.Authenticate(request, AuthenticationLevel.USER_EDIT_INGREDIENT))
		{
			EntityManager em;
			try {
				em = RecipeAppContext.createEntityManager();

		        EntityTransaction tran = em.getTransaction();	
		        
		        
		        tran.begin();
		        em.remove(em.getReference(Recipe.class, id));
				tran.commit();
				
				em.close();
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		throw new NotAuthorizedException("User must be authorized");
	}
}
