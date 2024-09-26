package edu.westga.cs1302.project1.model;

import java.util.List;

/**
 * Provides utility functions for counting pantry
 * 
 * @author Jake Miranda
 * @version Fall 2024
 * 
 */
public class CountPantry {

	/**
	 * Calculates quantity of food for set of food items.
	 * 
	 * @precondition food != null && food != 0
	 * @param food list of food to count quantity of food
	 * @return Returns count of pantry food quantity added together
	 */
	public static int countPantryFood(List<Food> food) {
		if (food == null) {
			throw new IllegalArgumentException("No food provided.");
		}
		if (food.size() == 0) {
			throw new IllegalArgumentException("No food provided");
		}
		int count = 0;
		for (Food currentFood : food) {
			count += currentFood.getQuantity();
		}
		return count;

	}

}
