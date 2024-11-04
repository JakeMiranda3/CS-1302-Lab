package edu.westga.cs1302.project2.test.model.utility;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project2.model.Ingredient;
import edu.westga.cs1302.project2.model.Recipe;
import edu.westga.cs1302.project2.model.Utility;

class TestRecipeToString {

	@Test
	void testWhenRecipeIsNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			Utility.recipeToString(null);
		});
	}

	@Test
	void testWhenRecipeHasOneIngredient() {
		ArrayList<Ingredient> listOfIngredients = new ArrayList<Ingredient>();
		Ingredient ingredient1 = new Ingredient("Turkey", "Meat");
		listOfIngredients.add(ingredient1);
		Recipe recipe = new Recipe("ThanksGiving Turkey", listOfIngredients);
		String result = Utility.recipeToString(recipe);
		assertEquals("ThanksGiving Turkey" + System.lineSeparator() + "Turkey-Meat" + System.lineSeparator(), result,
				"Checks recipeToString when theres one ingredient.");

	}

	@Test
	void testWhenRecipeHasTwoIngredients() {
		ArrayList<Ingredient> listOfIngredients = new ArrayList<Ingredient>();
		Ingredient ingredient1 = new Ingredient("Turkey", "Meat");
		Ingredient ingredient2 = new Ingredient("Cranberry", "Fruit");
		listOfIngredients.add(ingredient1);
		listOfIngredients.add(ingredient2);
		Recipe recipe = new Recipe("ThanksGiving Turkey", listOfIngredients);
		String result = Utility.recipeToString(recipe);
		assertEquals("ThanksGiving Turkey" + System.lineSeparator() + "Turkey-Meat, Cranberry-Fruit"
				+ System.lineSeparator(), result, "Checks recipeToString when theres two ingredients.");

	}

}
