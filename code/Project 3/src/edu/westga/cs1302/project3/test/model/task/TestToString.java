package edu.westga.cs1302.project3.test.model.task;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project3.model.Task;

class TestToString {

	@Test
	void testToString() {
		Task task1 = new Task("Task 1", "Test Task");
		assertEquals("Task 1", task1.toString(), "Checks the title of the task");
	}

}
