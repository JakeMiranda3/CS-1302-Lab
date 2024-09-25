package edu.westga.cs1302.project1.test.model.food;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project1.model.Food;

class DecreaseQuantity {

	@Test
	void testWhenQuantityIsZero() {
		Food food = new Food("Steak", "Meat");
		assertThrows(IllegalArgumentException.class, () -> {
			food.decreaseQuantity();
		});
	}

	@Test
	void testWhenDecreaseQuantityIsCalledOnce() {
		Food food = new Food("Steak", "Meat");
		food.setQuantity(5);
		food.decreaseQuantity();
		assertEquals("Steak", food.getName(), "Checks the name of the food");
		assertEquals("Meat", food.getType(), "Checks the type of food");
		assertEquals(4, food.getQuantity(), "Checks the quantity of food");
	}

	@Test
	void testWhenDecreaseQuantityIsCalledMoreThanOnce() {
		Food food = new Food("Steak", "Meat");
		food.setQuantity(5);
		food.decreaseQuantity();
		food.decreaseQuantity();
		assertEquals("Steak", food.getName(), "Checks the name of the food");
		assertEquals("Meat", food.getType(), "Checks the type of food");
		assertEquals(3, food.getQuantity(), "Checks the quantity of food");
	}

}
