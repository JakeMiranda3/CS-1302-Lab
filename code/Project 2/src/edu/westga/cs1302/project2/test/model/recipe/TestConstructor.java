package edu.westga.cs1302.project2.test.model.recipe;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project2.model.Ingredient;
import edu.westga.cs1302.project2.model.Recipe;

class TestConstructor {

	@Test
	void testWhenNameIsEmpty() {
		ArrayList<Ingredient> listOfIngredients = new ArrayList<Ingredient>();
		Ingredient ingredient1 = new Ingredient("Steak", "Meat");
		listOfIngredients.add(ingredient1);
		assertThrows(IllegalArgumentException.class, () -> {
			new Recipe("", listOfIngredients);
		});

	}

	@Test
	void testWhenNameIsNull() {
		ArrayList<Ingredient> listOfIngredients = new ArrayList<Ingredient>();
		Ingredient ingredient1 = new Ingredient("Steak", "Meat");
		listOfIngredients.add(ingredient1);
		assertThrows(IllegalArgumentException.class, () -> {
			new Recipe(null, listOfIngredients);
		});

	}

	@Test
	void testWhenIngredientsIsEmpty() {
		ArrayList<Ingredient> listOfIngredients = new ArrayList<Ingredient>();
		assertThrows(IllegalArgumentException.class, () -> {
			new Recipe("Filet Mignon", listOfIngredients);
		});

	}

	@Test
	void testWhenIngredientsIsNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Recipe("Filet Mignon", null);
		});

	}

	@Test
	void testWhenAValidRecipeIsCreated() {
		ArrayList<Ingredient> listOfIngredients = new ArrayList<Ingredient>();
		Ingredient ingredient1 = new Ingredient("Steak", "Meat");
		listOfIngredients.add(ingredient1);
		Recipe recipe = new Recipe("Filet Mignon", listOfIngredients);
		assertEquals("Filet Mignon", recipe.getName(), "Checks the name of the recipe");
		assertEquals("Steak-Meat", recipe.getIngredients().get(0).toString(), "Checks the ingredients in the recipe");
	}

}
