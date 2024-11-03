package edu.westga.cs1302.project2.test.model.ingredient_name_comparator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project2.model.IngredientNameComparator;

class TestToString {

	@Test
	void testToString() {
		String result = new IngredientNameComparator().toString();
		assertEquals("Name", result, "Checks the result of the IngredientNameComparator toString()");
	}

}
