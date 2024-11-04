package edu.westga.cs1302.project2.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Loads recipes from a file
 * 
 * @author Jake Miranda
 * @version Fall 2024
 */
public class LoadRecipesFromFile {

	public static final String DATA_FILE = "data.txt";

	/**
	 * Loads a list of recipes from a file
	 * 
	 * @precondition reader.hasNextLine() && inputFile.exist()
	 * @return Returns an ArrayList of recipes
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public ArrayList<Recipe> loadRecipes() throws FileNotFoundException, IOException {

		ArrayList<Recipe> recipes = new ArrayList<Recipe>();
		File inputFile = new File(DATA_FILE);
		try (Scanner reader = new Scanner(inputFile)) {
			if (!reader.hasNextLine() || !inputFile.exists()) {
				return recipes;
			}

			for (int lineNumber = 1; reader.hasNextLine(); lineNumber++) {
				String recipeName = reader.nextLine();
				String baseLine = reader.nextLine();
				String strippedLine = baseLine.strip();
				String[] ingredients = strippedLine.split(",");
				ArrayList<Ingredient> ingredientList = new ArrayList<Ingredient>();
				for (String currIngredient : ingredients) {
					String[] parts = currIngredient.split("-");
					try {
						String ingredientName = parts[0];
						String ingredientType = parts[1];
						Ingredient nextIngredient = new Ingredient(ingredientName, ingredientType);
						ingredientList.add(nextIngredient);
					} catch (IllegalArgumentException ingredientError) {
						throw new IOException(
								"Unable to create ingredient, bad name/type" + lineNumber + " : " + strippedLine);
					}
				}
				Recipe currRecipe = new Recipe(recipeName, ingredientList);
				recipes.add(currRecipe);
			}
		}

		return recipes;

	}

	/**
	 * Loads a list of recipes from a file with a specific ingredient
	 * 
	 * @param ingredient Specific ingredient
	 * @return Returns a list of recipes with a specific ingredient
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public ArrayList<Recipe> loadRecipesWithSpecifiedIngredient(Ingredient ingredient)
			throws FileNotFoundException, IOException {
		ArrayList<Recipe> recipeList = this.loadRecipes();
		ArrayList<Recipe> recipesWithSpecificIngredient = new ArrayList<Recipe>();
		for (Recipe currRecipe : recipeList) {
			for (Ingredient currIngredient : currRecipe.getIngredients()) {
				if (currIngredient.getName().equalsIgnoreCase(ingredient.getName())) {
					recipesWithSpecificIngredient.add(currRecipe);
				}
			}
		}

		return recipesWithSpecificIngredient;
	}
}
