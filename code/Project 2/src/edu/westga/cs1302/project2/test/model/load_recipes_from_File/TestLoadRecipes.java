package edu.westga.cs1302.project2.test.model.load_recipes_from_File;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project2.model.Ingredient;
import edu.westga.cs1302.project2.model.LoadRecipesFromFile;
import edu.westga.cs1302.project2.model.Recipe;
import edu.westga.cs1302.project2.model.RecipeToFile;

class TestLoadRecipes {

	@BeforeEach
	public void setUp() throws IOException {
		File input = new File(RecipeToFile.DATA_FILE);
		FileWriter writer = new FileWriter(input);
		writer.write("");
		writer.close();

	}

	@Test
	void testNoRecipeInFile() throws IOException {
		LoadRecipesFromFile load = new LoadRecipesFromFile();
		ArrayList<Recipe> recipes = load.loadRecipes();
		assertEquals(0, recipes.size(), "Checks the number of recipes loaded");
	}

	@Test
	void testOneRecipeInFile() throws IOException {
		ArrayList<Ingredient> listOfIngredients = new ArrayList<Ingredient>();
		Ingredient ingredient1 = new Ingredient("Turkey", "Meat");
		Ingredient ingredient2 = new Ingredient("Cranberry", "Fruit");
		listOfIngredients.add(ingredient1);
		listOfIngredients.add(ingredient2);
		Recipe recipe = new Recipe("ThanksGiving Turkey", listOfIngredients);
		RecipeToFile writer = new RecipeToFile();
		writer.writeRecipeToFile(recipe);
		LoadRecipesFromFile load = new LoadRecipesFromFile();
		ArrayList<Recipe> recipes = load.loadRecipes();
		assertEquals(1, recipes.size(), "Checks the number of recipes loaded");
		assertEquals("ThanksGiving Turkey", recipes.get(0).getName(), "Checks the name of the first recipe");
		assertEquals("Turkey", recipes.get(0).getIngredients().get(0).getName(),
				"Checks the name of the first ingredient");
		assertEquals("Meat", recipes.get(0).getIngredients().get(0).getType(),
				"Checks the type of the first ingredient");

		assertEquals("Cranberry", recipes.get(0).getIngredients().get(1).getName(),
				"Checks the name of the second ingredient");
		assertEquals("Fruit", recipes.get(0).getIngredients().get(1).getType(),
				"Checks the type of the second ingredient");

	}

	@Test
	void testTwoRecipesInFile() throws IOException {
		ArrayList<Ingredient> listOfIngredients = new ArrayList<Ingredient>();
		Ingredient ingredient1 = new Ingredient("Turkey", "Meat");
		Ingredient ingredient2 = new Ingredient("Cranberry", "Fruit");
		listOfIngredients.add(ingredient1);
		listOfIngredients.add(ingredient2);
		Recipe recipe = new Recipe("ThanksGiving Turkey", listOfIngredients);
		RecipeToFile writer = new RecipeToFile();
		writer.writeRecipeToFile(recipe);
		Ingredient ingredient3 = new Ingredient("Steak", "Meat");
		ArrayList<Ingredient> listOfIngredients2 = new ArrayList<Ingredient>();
		listOfIngredients2.add(ingredient3);
		Recipe recipe2 = new Recipe("Filet Mignon", listOfIngredients2);
		writer.writeRecipeToFile(recipe2);
		LoadRecipesFromFile load = new LoadRecipesFromFile();
		ArrayList<Recipe> recipes = load.loadRecipes();
		assertEquals(2, recipes.size(), "Checks the number of recipes loaded");
		assertEquals("ThanksGiving Turkey", recipes.get(0).getName(), "Checks the name of the first recipe");
		assertEquals("Turkey", recipes.get(0).getIngredients().get(0).getName(),
				"Checks the name of the first ingredient");
		assertEquals("Meat", recipes.get(0).getIngredients().get(0).getType(),
				"Checks the type of the first ingredient");
		assertEquals("Cranberry", recipes.get(0).getIngredients().get(1).getName(),
				"Checks the name of the second ingredient");
		assertEquals("Fruit", recipes.get(0).getIngredients().get(1).getType(),
				"Checks the type of the second ingredient");

		assertEquals("Filet Mignon", recipes.get(1).getName(), "Checks the name of the second recipe");
		assertEquals("Steak", recipes.get(1).getIngredients().get(0).getName(),
				"Checks the name of the first ingredient");
		assertEquals("Meat", recipes.get(1).getIngredients().get(0).getType(),
				"Checks the type of the first ingredient");

	}

}
