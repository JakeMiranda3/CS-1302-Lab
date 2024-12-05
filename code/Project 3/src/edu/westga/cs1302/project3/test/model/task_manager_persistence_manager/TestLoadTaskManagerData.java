package edu.westga.cs1302.project3.test.model.task_manager_persistence_manager;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project3.model.TaskManager;
import edu.westga.cs1302.project3.model.TaskManagerPersistenceManager;

class TestLoadTaskManagerData {

	private static final String DATA_FILE = "data.txt";

	@BeforeEach
	public void setUp() throws IOException {
		File input = new File(DATA_FILE);
		FileWriter writer = new FileWriter(input);
		writer.write("");
		writer.close();

	}

	@Test
	void testEmptyFile() {
		assertThrows(IllegalArgumentException.class, () -> {
			TaskManagerPersistenceManager.loadTaskManagerData("");
		});
	}

	@Test
	void testNullFile() {
		assertThrows(IllegalArgumentException.class, () -> {
			TaskManagerPersistenceManager.loadTaskManagerData(null);
		});
	}

	@Test
	void testEmptyTaskInFile() throws IOException {
		TaskManager manager = TaskManagerPersistenceManager.loadTaskManagerData(DATA_FILE);
		assertTrue(manager.getTask().isEmpty());

	}

	@Test
	void testOneTaskInFile() throws IOException {
		try (FileWriter writer = new FileWriter(DATA_FILE)) {
			writer.write("Title" + System.lineSeparator());
			writer.write("Description" + System.lineSeparator());
		}
		TaskManager manager = TaskManagerPersistenceManager.loadTaskManagerData(DATA_FILE);
		assertEquals("Title", manager.getTask().get(0).getTitle(), "Checks the first line");
		assertEquals("Description", manager.getTask().get(0).getDescription(), "Checks the second line");

	}

	@Test
	void testTwoTaskInFile() throws IOException {
		try (FileWriter writer = new FileWriter(DATA_FILE)) {
			writer.write("Title" + System.lineSeparator());
			writer.write("Description" + System.lineSeparator());
			writer.write("Title2" + System.lineSeparator());
			writer.write("Description2" + System.lineSeparator());
		}
		TaskManager manager = TaskManagerPersistenceManager.loadTaskManagerData(DATA_FILE);
		assertEquals("Title", manager.getTask().get(0).getTitle(), "Checks the first line");
		assertEquals("Description", manager.getTask().get(0).getDescription(), "Checks the second line");
		assertEquals("Title2", manager.getTask().get(1).getTitle(), "Checks the third line");
		assertEquals("Description2", manager.getTask().get(1).getDescription(), "Checks the fourth line");

	}

}
