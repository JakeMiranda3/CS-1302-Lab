package edu.westga.cs1302.project2.model;

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
				recipeText += ", ";
			}
		}

		return recipeText + System.lineSeparator();

	}

}
