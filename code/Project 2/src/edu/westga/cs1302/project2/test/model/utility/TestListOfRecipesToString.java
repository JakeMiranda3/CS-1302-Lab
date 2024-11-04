package edu.westga.cs1302.project2.test.model.utility;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project2.model.Ingredient;
import edu.westga.cs1302.project2.model.Recipe;
import edu.westga.cs1302.project2.model.Utility;

class TestListOfRecipesToString {

	@Test
	void testWhenListOfRecipesAreNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			Utility.listOfRecipesToString(null);
		});
	}

	@Test
	void testWhenListOfRecipesAreEmpty() {
		ArrayList<Recipe> recipes = new ArrayList<Recipe>();
		assertThrows(IllegalArgumentException.class, () -> {
			Utility.listOfRecipesToString(recipes);
		});
	}

	@Test
	void testWhenRecipeListHasOneRecipe() {
		ArrayList<Ingredient> listOfIngredients = new ArrayList<Ingredient>();
		ArrayList<Recipe> listOfRecipes = new ArrayList<Recipe>();
		Ingredient ingredient1 = new Ingredient("Turkey", "Meat");
		listOfIngredients.add(ingredient1);
		Recipe recipe = new Recipe("ThanksGiving Turkey", listOfIngredients);
		listOfRecipes.add(recipe);
		String result = Utility.listOfRecipesToString(listOfRecipes);
		assertEquals("ThanksGiving Turkey" + System.lineSeparator() + "Turkey-Meat" + System.lineSeparator()
				+ System.lineSeparator(), result, "Checks listOfRecipesToString when theres one recipe.");

	}

	@Test
	void testWhenRecipeListHasMultipleRecipes() {
		ArrayList<Ingredient> listOfIngredients = new ArrayList<Ingredient>();
		ArrayList<Recipe> listOfRecipes = new ArrayList<Recipe>();
		Ingredient ingredient1 = new Ingredient("Turkey", "Meat");
		listOfIngredients.add(ingredient1);
		Recipe recipe1 = new Recipe("ThanksGiving Turkey", listOfIngredients);
		listOfRecipes.add(recipe1);
		ArrayList<Ingredient> listOfIngredients2 = new ArrayList<Ingredient>();
		Ingredient ingredient2 = new Ingredient("Steak", "Meat");
		listOfIngredients2.add(ingredient2);
		Recipe recipe2 = new Recipe("Filet Mignon", listOfIngredients2);
		listOfRecipes.add(recipe2);
		String result = Utility.listOfRecipesToString(listOfRecipes);
		String expected = "ThanksGiving Turkey" + System.lineSeparator() + "Turkey-Meat" + System.lineSeparator()
				+ System.lineSeparator();
		expected += "Filet Mignon" + System.lineSeparator() + "Steak-Meat" + System.lineSeparator()
				+ System.lineSeparator();
		assertEquals(expected, result, "Checks listOfRecipesToString when theres two recipes.");
	}

}
