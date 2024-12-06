package edu.westga.cs1302.project3.test.viewmodel;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project3.viewmodel.ViewModel;

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
		ViewModel vm = new ViewModel();
		assertThrows(IllegalArgumentException.class, () -> {
			vm.loadTaskManagerData("");
		});

	}

	@Test
	void testNullFile() {
		ViewModel vm = new ViewModel();
		assertThrows(IllegalArgumentException.class, () -> {
			vm.loadTaskManagerData(null);
		});
	}

	@Test
	void testEmptyTaskInFile() throws IOException {
		ViewModel vm = new ViewModel();
		assertThrows(IllegalArgumentException.class, () -> {
			vm.loadTaskManagerData(DATA_FILE);
		});
	}

	@Test
	void testOneTaskInFile() throws IOException {
		ViewModel vm = new ViewModel();
		try (FileWriter writer = new FileWriter(DATA_FILE)) {
			writer.write("Title" + System.lineSeparator());
			writer.write("Description" + System.lineSeparator());
		}
		vm.loadTaskManagerData(DATA_FILE);
		assertEquals("Title", vm.getTasks().get(0).getTitle(), "Checks the title of the task");
		assertEquals("Description", vm.getTasks().get(0).getDescription(), "Checks description of the task");
	}

	@Test
	void testTwoTaskInFile() throws IOException {
		ViewModel vm = new ViewModel();
		try (FileWriter writer = new FileWriter(DATA_FILE)) {
			writer.write("Title" + System.lineSeparator());
			writer.write("Description" + System.lineSeparator());
			writer.write("Title 2" + System.lineSeparator());
			writer.write("Description 2" + System.lineSeparator());
		}
		vm.loadTaskManagerData(DATA_FILE);
		assertEquals("Title", vm.getTasks().get(0).getTitle(), "Checks the title of the task");
		assertEquals("Description", vm.getTasks().get(0).getDescription(), "Checks description of the task");
		assertEquals("Title 2", vm.getTasks().get(1).getTitle(), "Checks the title of the task");
		assertEquals("Description 2", vm.getTasks().get(1).getDescription(), "Checks description of the task");
	}

}
