package edu.westga.cs1302.project3.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Supports saving and loading Tasks data
 * 
 * @author Jake Miranda
 * @version Fall 2024
 */
public class TaskManagerPersistenceManager {
	/**
	 * Writes all task data to specified file
	 * 
	 * @precondition manger != null && !manager.getTask().isEmpty()
	 * @precondition dataFile != null && !dataFile.isEmpty()
	 * 
	 * @param manager  The tasks to save
	 * @param dataFile The specific file the user wants to use
	 * @throws IOException
	 */
	public static void saveTaskManagerData(TaskManager manager, String dataFile) throws IOException {
		if (manager == null) {
			throw new IllegalArgumentException("Must provide task manager.");
		}
		if (manager.getTask().isEmpty()) {
			throw new IllegalArgumentException("Must have tasks in task manager.");
		}

		if (dataFile == null || dataFile.isEmpty()) {
			throw new IllegalArgumentException("Data file cant be null or empty.");
		}

		try (FileWriter writer = new FileWriter(dataFile)) {
			for (Task currTask : manager.getTask()) {
				writer.write(currTask.getTitle() + System.lineSeparator() + currTask.getDescription()
						+ System.lineSeparator());

			}
		}
	}

	/**
	 * Reads from the specified dataFile
	 * 
	 * @precondition dataFile != null && !dataFile.isEmpty()
	 * @param dataFile Specified file the user wants to use
	 * @return Returns the task manager loaded
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static TaskManager loadTaskManagerData(String dataFile) throws FileNotFoundException, IOException {
		if (dataFile == null || dataFile.isEmpty()) {
			throw new IllegalArgumentException("Data file cant be null or empty.");
		}
		TaskManager manager = new TaskManager();
		File inputFile = new File(dataFile);
		try (Scanner reader = new Scanner(inputFile)) {
			while (reader.hasNextLine()) {
				String title = reader.nextLine();
				String description = reader.nextLine();
				Task task = new Task(title, description);
				manager.addTask(task);

			}
		} catch (IllegalArgumentException error) {
			throw new IllegalArgumentException("Unable to create task bad title/description.");
		}
		if (manager.getTask().isEmpty()) {
			throw new IllegalArgumentException("The selected file is not in the appropriate format.");
		}
		return manager;
	}

}
