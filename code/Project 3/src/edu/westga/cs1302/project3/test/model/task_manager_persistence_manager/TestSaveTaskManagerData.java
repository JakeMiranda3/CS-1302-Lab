package edu.westga.cs1302.project3.test.model.task_manager_persistence_manager;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project3.model.Task;
import edu.westga.cs1302.project3.model.TaskManager;
import edu.westga.cs1302.project3.model.TaskManagerPersistenceManager;

class TestSaveTaskManagerData {
	private static final String DATA_FILE = "data.txt";

	@Test
	void testNullTaskManager() {
		assertThrows(IllegalArgumentException.class, () -> {
			TaskManagerPersistenceManager.saveTaskManagerData(null, DATA_FILE);
		});
	}

	@Test
	void testNoTasksInTaskManager() {
		TaskManager manager = new TaskManager();
		assertThrows(IllegalArgumentException.class, () -> {
			TaskManagerPersistenceManager.saveTaskManagerData(manager, DATA_FILE);
		});
	}

	@Test
	void testNullDataFile() {
		TaskManager manager = new TaskManager();
		assertThrows(IllegalArgumentException.class, () -> {
			TaskManagerPersistenceManager.saveTaskManagerData(manager, null);
		});
	}

	@Test
	void testEmptyDataFile() {
		TaskManager manager = new TaskManager();
		assertThrows(IllegalArgumentException.class, () -> {
			TaskManagerPersistenceManager.saveTaskManagerData(manager, "");
		});
	}

	@Test
	void testWhenOneTaskInTaskManager() throws IOException {
		TaskManager manager = new TaskManager();
		Task task1 = new Task("Title", "Description");
		manager.addTask(task1);
		TaskManagerPersistenceManager.saveTaskManagerData(manager, DATA_FILE);
		File inputFile = new File(DATA_FILE);
		try (Scanner reader = new Scanner(inputFile)) {
			assertEquals("Title", reader.nextLine(), "Checks the first line of the file");
			assertEquals("Description", reader.nextLine(), "Checks the second line of the file");

		}
	}

	@Test
	void testWhenTwoTasksInManager() throws IOException {
		TaskManager manager = new TaskManager();
		Task task1 = new Task("Title", "Description");
		manager.addTask(task1);
		Task task2 = new Task("Title2", "Description2");
		manager.addTask(task2);
		TaskManagerPersistenceManager.saveTaskManagerData(manager, DATA_FILE);
		File inputFile = new File(DATA_FILE);
		try (Scanner reader = new Scanner(inputFile)) {
			assertEquals("Title", reader.nextLine(), "Checks the first line of the file");
			assertEquals("Description", reader.nextLine(), "Checks the second line of the file");
			assertEquals("Title2", reader.nextLine(), "Checks the third line of the file");
			assertEquals("Description2", reader.nextLine(), "Checks the fourth line of the file");
		}
	}

}
