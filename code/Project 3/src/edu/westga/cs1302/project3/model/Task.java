package edu.westga.cs1302.project3.model;

/**
 * Stores title and description of a single task
 * 
 * @author Jake Miranda
 * @version Fall 2024
 */
public class Task {
	private String title;
	private String description;

	/**
	 * Creates a new Task with specified title and description
	 * 
	 * @precondition !title.isEmpty() && name != null
	 * @precondition !description.isEmpty() && description != null
	 * @param title       Title of the task
	 * @param description Description of the task
	 */
	public Task(String title, String description) {
		if (title == null || title.isEmpty()) {
			throw new IllegalArgumentException("Title cannot be null or empty.");
		}
		if (description == null || description.isEmpty()) {
			throw new IllegalArgumentException("Description cannot be null or empty.");
		}
		this.title = title;
		this.description = description;
	}

	/**
	 * Gets the name of the Task
	 * 
	 * @return Returns the name of the task
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * Gets the description of the task
	 * 
	 * @return Returns the description of the task
	 */
	public String getDescription() {
		return this.description;
	}
	
	@Override
	public String toString() {
		return this.title;
	}

}
