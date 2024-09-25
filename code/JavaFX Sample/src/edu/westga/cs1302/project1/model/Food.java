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

	/**
	 * Sets the quantity of food passed through the parameter
	 * 
	 * @precondition num >= 0
	 * 
	 * @param num The number of food
	 * @throws IllegalArgumentException when precondition is violated
	 */
	public void setQuantity(int num) throws IllegalArgumentException {
		if (num < 0) {
			throw new IllegalArgumentException("Quantity can't be less than zero.");
		}
		this.quantity = num;
	}

	/**
	 * Increases the quantity of food by one.
	 */
	public void increaseQuantity() {
		this.quantity++;
	}

	/**
	 * Decreases the quantity of food by one
	 * 
	 * @precondition this.quantity != 0
	 * 
	 * @throws IllegalArgumentException when precondition is violated
	 */
	public void decreaseQuantity() throws IllegalArgumentException {
		if (this.quantity == 0) {
			throw new IllegalArgumentException("Quantity can't be decreased to less than zero.");
		}
		this.quantity--;
	}

	@Override
	public String toString() {
		return this.name + " - " + this.quantity;
	}

}
