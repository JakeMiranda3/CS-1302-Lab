package edu.westga.cs1302.project3.viewmodel;

import java.io.FileNotFoundException;
import java.io.IOException;

import edu.westga.cs1302.project3.model.Task;
import edu.westga.cs1302.project3.model.TaskManager;
import edu.westga.cs1302.project3.model.TaskManagerPersistenceManager;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
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

	/**
	 * Initializes the properties for the viewmodel
	 */
	public ViewModel() {
		this.manager = new TaskManager();
		this.manager.addTask(new Task("Default Task 1", "First task"));
		this.manager.addTask(new Task("Default Task 2", "Second task"));
		this.listOfTask = new SimpleListProperty<Task>(FXCollections.observableArrayList(this.manager.getTask()));
	}

	/**
	 * Return a tasks list property
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

}