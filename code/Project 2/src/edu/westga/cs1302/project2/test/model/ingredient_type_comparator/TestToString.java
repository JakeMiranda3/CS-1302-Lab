package edu.westga.cs1302.project2.test.model.ingredient_type_comparator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project2.model.IngredientTypeComparator;

class TestToString {

	@Test
	void testToString() {
		String result = new IngredientTypeComparator().toString();
		assertEquals("Type", result, "Check's the result of the IngredientNameComparator toString()");
	}

}
