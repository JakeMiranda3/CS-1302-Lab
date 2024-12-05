package edu.westga.cs1302.project3.model;

import java.util.ArrayList;

/**
 * Manages a set of Tasks
 * 
 * @author Jake Miranda
 * @version Fall 2024
 */
public class TaskManager {
	private ArrayList<Task> tasks;

	/**
	 * Creates a new empty TaskManager with list of tasks.
	 */
	public TaskManager() {
		this.tasks = new ArrayList<Task>();
	}

	/**
	 * Gets the list of tasks
	 * 
	 * @return Returns the list of tasks
	 */
	public ArrayList<Task> getTask() {
		return this.tasks;
	}

	/**
	 * Returns the number of tasks in the task manager
	 * 
	 * @return Returns the number of tasks in the task manager
	 */
	public int getSize() {
		return this.tasks.size();
	}

	/**
	 * Adds the task to the task manager
	 * 
	 * @precondition task != null
	 * @param task The task to be added to the task manager
	 */
	public void addTask(Task task) {
		if (task == null) {
			throw new IllegalArgumentException("Task cannot be null.");
		}
		this.tasks.add(task);

	}

	/**
	 * Removes task from the task manager
	 * 
	 * @precondition task != null
	 * @param task The task to be removed from the task manager
	 */
	public void removeTask(Task task) {
		if (task == null) {
			throw new IllegalArgumentException("Task cannot be null.");
		}
		this.tasks.remove(task);

	}

}
