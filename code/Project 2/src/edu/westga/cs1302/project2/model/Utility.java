package edu.westga.cs1302.project2.model;

import java.util.ArrayList;

/**
 * Utility class that handles converting a recipe to a string
 * 
 * @author Jake Miranda
 * @version Fall 2024
 */
public class Utility {
	/**
	 * Converts a recipe to a string
	 * 
	 * @precondition recipe != null
	 * @param recipe A recipe that includes a name and list of ingredients
	 * @return Returns a String with recipe name and list of ingredients comma
	 *         separated
	 */
	public static String recipeToString(Recipe recipe) {
		if (recipe == null) {
			throw new IllegalArgumentException("Recipe can't be null.");
		}
		String recipeText;
		recipeText = recipe.getName() + System.lineSeparator();
		for (int index = 0; index < recipe.getIngredients().size(); index++) {
			recipeText += recipe.getIngredients().get(index);
			if (recipe.getIngredients().size() - 1 > index) {
				recipeText += ",";
			}
		}

		return recipeText + System.lineSeparator();

	}

	/**
	 * Converts a list of recipes to a string
	 * 
	 * @precondition recipes != null && !recipes.isEmpty()
	 * @param recipes A list containing recipes
	 * @return Returns a String with a list of recipes
	 */
	public static String listOfRecipesToString(ArrayList<Recipe> recipes) {
		if (recipes == null || recipes.isEmpty()) {
			throw new IllegalArgumentException("Recipes can't be null or empty.");
		}
		String recipesText = "";
		for (Recipe currRecipe : recipes) {
			recipesText += recipeToString(currRecipe) + System.lineSeparator();
		}
		return recipesText;
	}

}
