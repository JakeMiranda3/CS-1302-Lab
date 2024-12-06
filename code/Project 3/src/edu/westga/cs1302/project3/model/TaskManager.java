package edu.westga.cs1302.project3.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Manages a set of Tasks
 * 
 * @author Jake Miranda
 * @version Fall 2024
 */
public class TaskManager {
	private ArrayList<Task> tasks;
	private Map<String, Task> taskLookUp;

	/**
	 * Creates a new empty TaskManager with list of tasks.
	 */
	public TaskManager() {
		this.tasks = new ArrayList<Task>();
		this.taskLookUp = new HashMap<>();
	}

	/**
	 * Stores the Task title, and Task with that Title as the key
	 * 
	 * @param title Title of the task
	 * @param task  Task object
	 */
	public void addTaskToMap(String title, Task task) {
		this.taskLookUp.put(title, task);
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
		if (!this.taskLookUp.containsKey(task.getTitle())) {
			this.tasks.add(task);
			this.addTaskToMap(task.getTitle(), task);
		}

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
		this.taskLookUp.remove(task.getTitle());

	}

}
