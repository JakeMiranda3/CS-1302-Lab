package edu.westga.cs1302.project3.viewmodel;

import java.io.FileNotFoundException;
import java.io.IOException;

import edu.westga.cs1302.project3.model.Task;
import edu.westga.cs1302.project3.model.TaskManager;
import edu.westga.cs1302.project3.model.TaskManagerPersistenceManager;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;

/**
 * Manages utilizing the model and makes properties available to bind the UI
 * elements.
 *
 * @author Jake Miranda
 * @version Fall 2024
 */
public class ViewModel {
	private TaskManager manager;

	private ListProperty<Task> listOfTask;

	private StringProperty taskTitle;
	private StringProperty taskDescription;

	private ObjectProperty<Task> selectedTask;

	/**
	 * Initializes the properties for the viewmodel
	 */
	public ViewModel() {
		this.manager = new TaskManager();
		this.manager.addTask(new Task("Default Task 1", "First task"));
		this.manager.addTask(new Task("Default Task 2", "Second task"));
		this.listOfTask = new SimpleListProperty<Task>(FXCollections.observableArrayList(this.manager.getTask()));

		this.taskTitle = new SimpleStringProperty("");
		this.taskDescription = new SimpleStringProperty("");

		this.selectedTask = new SimpleObjectProperty<Task>(null);

	}

	/**
	 * Gets the selected task
	 * 
	 * @return Returns the selected tasks
	 */
	public ObjectProperty<Task> getSelectedTask() {
		return this.selectedTask;
	}

	/**
	 * Gets a tasks list property
	 * 
	 * @return Returns a list property of tasks
	 */
	public ListProperty<Task> getTasks() {
		return this.listOfTask;
	}

	/**
	 * Reads from the specified dataFile
	 * 
	 * @param dataFile Specified file the user wants to use
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void loadTaskManagerData(String dataFile) throws FileNotFoundException, IOException {
		this.manager = TaskManagerPersistenceManager.loadTaskManagerData(dataFile);
		this.listOfTask.set(FXCollections.observableArrayList(this.manager.getTask()));

	}

	/**
	 * Writes all task data to specified file
	 * 
	 * 
	 * @param dataFile The specific file the user wants to use
	 * @throws IOException
	 */
	public void saveTaskManagerData(String dataFile) throws IOException {
		TaskManagerPersistenceManager.saveTaskManagerData(this.manager, dataFile);
	}

	/**
	 * Gets the title of the task
	 * 
	 * @return Returns the title of the task
	 */
	public StringProperty getTaskTitle() {
		return this.taskTitle;
	}

	/**
	 * Gets the description of the task
	 * 
	 * @return Returns the description of the task
	 */
	public StringProperty getTaskDescription() {
		return this.taskDescription;
	}

	/**
	 * Adds task to task manager with given title and description by user
	 */
	public void addTask() {
		String title = this.taskTitle.get();
		String description = this.taskDescription.get();
		if (title == null || title.isEmpty()) {
			throw new IllegalArgumentException("Title can't be null or empty");
		}
		if (description == null || description.isEmpty()) {
			throw new IllegalArgumentException("Description can't be null or empty");
		}
		Task task = new Task(title, description);
		this.manager.addTask(task);
		this.listOfTask.set(FXCollections.observableArrayList(this.manager.getTask()));

	}

	/**
	 * Removes currently selected task from task manager
	 * 
	 * @precondition currTask != null
	 */
	public void removeTask() {
		Task currTask = this.selectedTask.get();
		if (currTask != null) {
			this.manager.removeTask(currTask);
			this.listOfTask.set(FXCollections.observableArrayList(this.manager.getTask()));
		} else {
			throw new IllegalArgumentException("Please select a task to remove.");
		}
	}

}
