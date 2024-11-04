package edu.westga.cs1302.project2.model;

import java.util.ArrayList;

/**
 * Stores and manages the information for a recipe.
 * 
 * @author Jake Miranda
 * @version Fall 2024
 */
public class Recipe {
	private String name;
	private ArrayList<Ingredient> ingredients;

	/**
	 * Creates a new Recipe with specified name and list of ingredients.
	 * 
	 * @precondition !name.isEmpty() && name != null
	 * @precondition ingredients != null
	 * @param name        Name of the recipe
	 * @param ingredients List of ingredients
	 */
	public Recipe(String name, ArrayList<Ingredient> ingredients) {
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException("Name can't be empty or null.");
		}
		if (ingredients == null) {
			throw new IllegalArgumentException("Ingredients can't be null.");
		}
		if (ingredients.isEmpty()) {
			throw new IllegalArgumentException("Ingredient's can't be empty, please add ingredients.");
		}
		this.name = name;
		this.ingredients = ingredients;
	}

	/**
	 * Gets the name of the Recipe
	 * 
	 * @return Returns the name of the recipe
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Gets the list of ingredients for the recipe
	 * 
	 * @return Returns the list of ingredients
	 */
	public ArrayList<Ingredient> getIngredients() {
		return this.ingredients;
	}

}
