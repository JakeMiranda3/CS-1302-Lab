package edu.westga.cs1302.project3.test.viewmodel;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project3.model.Task;
import edu.westga.cs1302.project3.viewmodel.ViewModel;

class TestSaveTaskManagerData {
	private static final String DATA_FILE = "data.txt";
	private static final String LOCKED_DATA_FILE = "lock.txt";

	@Test
	void testNullDataFile() {
		ViewModel vm = new ViewModel();
		assertThrows(IllegalArgumentException.class, () -> {
			vm.saveTaskManagerData(null);
		});

	}

	@Test
	void testEmptyDataFile() {
		ViewModel vm = new ViewModel();
		assertThrows(IllegalArgumentException.class, () -> {
			vm.saveTaskManagerData("");
		});

	}

	@Test
	void testWhenTasksAreInTaskManager() throws IOException {
		ViewModel vm = new ViewModel();
		Task task1 = new Task("Title", "Description");
		vm.getTasks().add(task1);
		vm.saveTaskManagerData(DATA_FILE);
		File inputFile = new File(DATA_FILE);
		inputFile.setWritable(true, true);
		try (Scanner reader = new Scanner(inputFile)) {
			assertEquals("Default Task 1", reader.nextLine(), "Checks the first line of the file");
			assertEquals("First task", reader.nextLine(), "Checks the second line of the file");
			assertEquals("Default Task 2", reader.nextLine(), "Checks the first line of the file");
			assertEquals("Second task", reader.nextLine(), "Checks the second line of the file");

		}

	}

	@Test
	void testWhenFileIsLocked() {
		ViewModel vm = new ViewModel();
		File inputFile = new File(LOCKED_DATA_FILE);
		inputFile.setWritable(false);
		assertThrows(SecurityException.class, () -> {
			vm.saveTaskManagerData(LOCKED_DATA_FILE);
		});
	}

}
