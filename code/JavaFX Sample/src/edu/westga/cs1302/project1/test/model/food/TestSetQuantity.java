package edu.westga.cs1302.project1.test.model.food;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project1.model.Food;

class TestSetQuantity {

	@Test
	void testWhenSetQuantityIsLessThanZero() {
		Food food = new Food("Steak", "Meat");
		assertThrows(IllegalArgumentException.class, () -> {
			food.setQuantity(-1);

		});
	}

	@Test
	void testWhenSetQuantityIsZero() {
		Food food = new Food("Steak", "Meat");
		food.setQuantity(0);
		assertEquals("Steak", food.getName(), "Checks the name of the food");
		assertEquals("Meat", food.getType(), "Checks the type of food");
		assertEquals(0, food.getQuantity(), "Checks the quantity of food");
	}

	@Test
	void testWhenSetQuantityIsOne() {
		Food food = new Food("Steak", "Meat");
		food.setQuantity(1);
		assertEquals("Steak", food.getName(), "Checks the name of the food");
		assertEquals("Meat", food.getType(), "Checks the type of food");
		assertEquals(1, food.getQuantity(), "Checks the quantity of food");
	}

}
