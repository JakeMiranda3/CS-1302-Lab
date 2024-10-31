package edu.westga.cs1302.project2.model;

import java.util.Comparator;

/**
 * Compares Ingredient object types lexicographically
 * 
 * @author Jake Miranda
 * @version Fall 2024
 */
public class IngredientTypeComparator implements Comparator<Ingredient> {

	@Override
	public int compare(Ingredient o1, Ingredient o2) {
		return o1.getType().compareTo(o2.getType());

	}
}
