package edu.westga.cs1302.project1.test.model.food;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project1.model.Food;

class TestConstructor {

	@Test
	void testWhenFoodNameIsNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Food(null, "Vegatable");

		});
	}

	@Test
	void testWhenFoodTypeIsNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Food("Steak", null);

		});
	}

	@Test
	void testValidNameAndType() {
		Food food = new Food("Steak", "Meat");
		assertEquals("Steak", food.getName(), "Checks the name of the food");
		assertEquals("Meat", food.getType(), "Checks the type of food");
		assertEquals(0, food.getQuantity(), "Checks the quantity of food");
	}

}
