package edu.westga.cs1302.project1.test.model.food;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project1.model.Food;

class TestToString {

	@Test
	void testTestValidToString() {
		Food food = new Food("Steak", "Meat");
		assertEquals("Steak - 0", food.toString(), "Checks the toString method");
	}

}
