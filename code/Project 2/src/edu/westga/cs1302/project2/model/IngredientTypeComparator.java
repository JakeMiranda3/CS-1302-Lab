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
		if (o1 == null || o2 == null) {
			throw new IllegalArgumentException("Ingredient can't be null");
		}
		return o1.getType().compareToIgnoreCase(o2.getType());

	}

	@Override
	public String toString() {
		return "Type";
	}
}
