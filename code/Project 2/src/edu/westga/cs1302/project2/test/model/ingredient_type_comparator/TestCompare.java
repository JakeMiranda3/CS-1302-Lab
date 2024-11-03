package edu.westga.cs1302.project2.test.model.ingredient_type_comparator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project2.model.Ingredient;
import edu.westga.cs1302.project2.model.IngredientTypeComparator;

class TestCompare {

	@Test
	public void testWhenFirstIngredientIsNull() {
		Ingredient ingredient = new Ingredient("Steak", "Meat");
		assertThrows(IllegalArgumentException.class, () -> {
			new IngredientTypeComparator().compare(null, ingredient);
		});
	}

	@Test
	public void testWhenSecondIngredientIsNull() {
		Ingredient ingredient = new Ingredient("Steak", "Meat");
		assertThrows(IllegalArgumentException.class, () -> {
			new IngredientTypeComparator().compare(ingredient, null);
		});
	}

	@Test
	public void testWhenSecondTypeShouldComeFirst() {
		Ingredient ingredient1 = new Ingredient("Steak", "Meat");
		Ingredient ingredient2 = new Ingredient("Apple", "Fruit");

		assertEquals(true, new IngredientTypeComparator().compare(ingredient1, ingredient2) > 1,
				"Check's that compare the ingredients by type provides the correct return integer");
	}

	@Test
	public void testWhenBothNamesAreTheSame() {
		Ingredient ingredient1 = new Ingredient("Apple", "Fruit");
		Ingredient ingredient2 = new Ingredient("Apple", "Fruit");
		assertEquals(true, new IngredientTypeComparator().compare(ingredient1, ingredient2) == 0,
				"Check's that compare the ingredients by type provides the correct return integer");
	}

	@Test
	public void testWhenNamesAreAlreadyInOrder() {
		Ingredient ingredient1 = new Ingredient("Apple", "Fruit");
		Ingredient ingredient2 = new Ingredient("Steak", "Meat");
		assertEquals(true, new IngredientTypeComparator().compare(ingredient1, ingredient2) < 1,
				"Check's that compare the ingredients by type provides the correct return integer");

	}

}
