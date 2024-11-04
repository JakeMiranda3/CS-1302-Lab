package edu.westga.cs1302.project2.test.model.recipe_to_file;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project2.model.Ingredient;
import edu.westga.cs1302.project2.model.Recipe;
import edu.westga.cs1302.project2.model.RecipeToFile;

class TestWriteRecipeToFile {

	@BeforeEach
	public void setUp() throws IOException {
		File input = new File(RecipeToFile.DATA_FILE);
		FileWriter writer = new FileWriter(input);
		writer.write("");
		writer.close();

	}

	@Test
	void testWhenTheresANullRecipe() {
		RecipeToFile write = new RecipeToFile();
		assertThrows(IllegalArgumentException.class, () -> {
			write.writeRecipeToFile(null);
		});
	}

	@Test
	void testWhenTheresOneRecipe() throws FileNotFoundException, IOException {
		ArrayList<Ingredient> listOfIngredients = new ArrayList<Ingredient>();
		Ingredient ingredient1 = new Ingredient("Turkey", "Meat");
		listOfIngredients.add(ingredient1);
		Recipe recipe = new Recipe("ThanksGiving Turkey", listOfIngredients);
		RecipeToFile write = new RecipeToFile();

		write.writeRecipeToFile(recipe);
		File inputFile = new File(RecipeToFile.DATA_FILE);
		try (Scanner reader = new Scanner(inputFile)) {
			assertEquals("ThanksGiving Turkey", reader.nextLine(), "Checks the first line of the file");
			assertEquals("Turkey-Meat", reader.nextLine(), "Checks the second line of the file");
		}
	}

	@Test
	void testWhenTheresMultipleRecipes() throws FileNotFoundException, IOException {
		ArrayList<Ingredient> listOfIngredients1 = new ArrayList<Ingredient>();
		Ingredient ingredient1 = new Ingredient("Turkey", "Meat");
		listOfIngredients1.add(ingredient1);
		Recipe recipe = new Recipe("ThanksGiving Turkey", listOfIngredients1);

		ArrayList<Ingredient> listOfIngredients2 = new ArrayList<Ingredient>();
		Ingredient ingredient2 = new Ingredient("Steak", "Meat");
		listOfIngredients2.add(ingredient2);
		Recipe recipe2 = new Recipe("Filet Mignon", listOfIngredients2);
		RecipeToFile write = new RecipeToFile();

		write.writeRecipeToFile(recipe);
		write.writeRecipeToFile(recipe2);
		File inputFile = new File(RecipeToFile.DATA_FILE);
		try (Scanner reader = new Scanner(inputFile)) {
			assertEquals("ThanksGiving Turkey", reader.nextLine(), "Checks the first line of the file");
			assertEquals("Turkey-Meat", reader.nextLine(), "Checks the second line of the file");
			assertEquals("Filet Mignon", reader.nextLine(), "Checks the third line of the file");
			assertEquals("Steak-Meat", reader.nextLine(), "Checks the fourth line of the file");
		}
	}

	@Test
	void testWhenTheresDuplicateRecipes() throws FileNotFoundException, IOException {
		ArrayList<Ingredient> listOfIngredients1 = new ArrayList<Ingredient>();
		Ingredient ingredient1 = new Ingredient("Turkey", "Meat");
		listOfIngredients1.add(ingredient1);
		Recipe recipe = new Recipe("ThanksGiving Turkey", listOfIngredients1);
		RecipeToFile write = new RecipeToFile();
		write.writeRecipeToFile(recipe);
		assertThrows(IllegalStateException.class, () -> {
			write.writeRecipeToFile(recipe);
		});

	}

}
