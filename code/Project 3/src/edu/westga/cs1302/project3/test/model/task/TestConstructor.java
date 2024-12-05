package edu.westga.cs1302.project3.test.model.task;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project3.model.Task;

class TestConstructor {

	@Test
	void testWhenTitleIsEmpty() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("", "I have no title");
		});
	}

	@Test
	void testWhenTitleIsNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task(null, "My title is null");
		});
	}

	@Test
	void testWhenDescriptionIsEmpty() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("My description is empty", "");
		});
	}

	@Test
	void testWhenDescriptionIsNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("My description is null", null);
		});
	}

	@Test
	void testValidTitleAndDescription() {
		Task task = new Task("I have a title", "I have a description");
		assertEquals("I have a title", task.getTitle(), "checking the title of the task");
		assertEquals("I have a description", task.getDescription(), "checking the description of the task");
	}

}
