package edu.westga.cs1302.project1.model;

/**
 * Stores information for a food item
 * 
 * @author Jake Miranda
 * @version Fall 2024
 */
public class Food {
	private final String name;
	private final String type;
	private int quantity;

	/**
	 * Creates a new food with the provided name and type
	 * 
	 * @precondition name != null && type != null
	 * @postcondition getName() == name && getType() == type
	 * 
	 * @param name the name of the food
	 * @param type the type of food
	 * @throws IllegalArgumentException when precondition is violated
	 */
	public Food(String name, String type) throws IllegalArgumentException {
		if (name == null) {
			throw new IllegalArgumentException("Name must be provided.");
		}
		if (name.isBlank()) {
			throw new IllegalArgumentException("Name can't be blank.");
		}
		if (type == null) {
			throw new IllegalArgumentException("Type must be provided.");
		}
		if (type.isBlank()) {
			throw new IllegalArgumentException("Type can't be blank.");
		}
		this.name = name;
		this.type = type;
		this.quantity = 0;
	}

	/**
	 * Return the name of the food
	 * 
	 * @return the name of the food
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Return the type of food
	 * 
	 * @return the type of food
	 */
	public String getType() {
		return this.type;
	}

	/**
	 * Returns the quantity of food
	 * 
	 * @return the quantity of food
	 */
	public int getQuantity() {
		return this.quantity;
	}

	@Override
	public String toString() {
		return this.name + " - " + this.quantity;
	}

}
