package edu.westga.cs1302.project1.test.model.CountPantry;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project1.model.CountPantry;
import edu.westga.cs1302.project1.model.Food;

class CountPantryFood {

	@Test
	void testCountPantryWithNullItems() {
		assertThrows(IllegalArgumentException.class, () -> {
			CountPantry.countPantryFood(null);
		});
	}

	@Test
	void testCountPantryWithNoItems() {
		ArrayList<Food> foods = new ArrayList<Food>();
		assertThrows(IllegalArgumentException.class, () -> {
			CountPantry.countPantryFood(foods);
		});
	}

	@Test
	void testCountPantryWithOneFoodItem() {
		ArrayList<Food> foods = new ArrayList<Food>();
		Food food1 = new Food("Steak", "Meat");
		food1.setQuantity(2);
		foods.add(food1);
		assertEquals(2, CountPantry.countPantryFood(foods), "Checks the quantity count of the pantry");
	}

	@Test
	void testCountPantryWithMoreThanOneFoodItem() {
		ArrayList<Food> foods = new ArrayList<Food>();
		Food food1 = new Food("Steak", "Meat");
		food1.setQuantity(2);
		foods.add(food1);
		Food food2 = new Food("Tomato", "Vegetable");
		food2.setQuantity(4);
		foods.add(food2);
		assertEquals(6, CountPantry.countPantryFood(foods), "Checks the quantity count of the pantry");
	}

}
