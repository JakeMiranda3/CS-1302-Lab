package edu.westga.cs1302.project2.test.model.ingredient_name_comparator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project2.model.Ingredient;
import edu.westga.cs1302.project2.model.IngredientNameComparator;

class TestCompare {

	@Test
	public void testWhenFirstIngredientIsNull() {
		Ingredient ingredient = new Ingredient("Steak", "Meat");
		assertThrows(IllegalArgumentException.class, () -> {
			new IngredientNameComparator().compare(null, ingredient);
		});
	}

	@Test
	public void testWhenSecondIngredientIsNull() {
		Ingredient ingredient = new Ingredient("Steak", "Meat");
		assertThrows(IllegalArgumentException.class, () -> {
			new IngredientNameComparator().compare(ingredient, null);
		});
	}

	@Test
	public void testWhenSecondNameShouldComeFirst() {
		Ingredient ingredient1 = new Ingredient("Steak", "Meat");
		Ingredient ingredient2 = new Ingredient("Apple", "Fruit");

		assertEquals(true, new IngredientNameComparator().compare(ingredient1, ingredient2) > 1,
				"Check's that compare the ingredients by name provides the correct return integer");
	}

	@Test
	public void testWhenBothNamesAreTheSame() {
		Ingredient ingredient1 = new Ingredient("Apple", "Fruit");
		Ingredient ingredient2 = new Ingredient("Apple", "Fruit");
		assertEquals(true, new IngredientNameComparator().compare(ingredient1, ingredient2) == 0,
				"Check's that compare the ingredients by name provides the correct return integer");
	}

	@Test
	public void testWhenNamesAreAlreadyInOrder() {
		Ingredient ingredient1 = new Ingredient("Apple", "Fruit");
		Ingredient ingredient2 = new Ingredient("Steak", "Meat");
		assertEquals(true, new IngredientNameComparator().compare(ingredient1, ingredient2) < 1,
				"Check's that compare the ingredients by name provides the correct return integer");

	}

}
