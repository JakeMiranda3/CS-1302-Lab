package edu.westga.cs1302.project1.test.model.food;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project1.model.Food;

class IncreaseQuantity {

	@Test
	void testWhenIncreaseQuantityIsCalledOnce() {
		Food food = new Food("Steak", "Meat");
		food.increaseQuantity();
		assertEquals("Steak", food.getName(), "Checks the name of the food");
		assertEquals("Meat", food.getType(), "Checks the type of food");
		assertEquals(1, food.getQuantity(), "Checks the quantity of food");
	}

	@Test
	void testWhenIncreaseQuantityIsCalledMoreThanOnce() {
		Food food = new Food("Steak", "Meat");
		food.increaseQuantity();
		food.increaseQuantity();
		assertEquals("Steak", food.getName(), "Checks the name of the food");
		assertEquals("Meat", food.getType(), "Checks the type of food");
		assertEquals(2, food.getQuantity(), "Checks the quantity of food");
	}

}
