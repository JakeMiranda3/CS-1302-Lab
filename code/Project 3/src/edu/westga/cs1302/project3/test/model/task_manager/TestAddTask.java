package edu.westga.cs1302.project3.test.model.task_manager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project3.model.Task;
import edu.westga.cs1302.project3.model.TaskManager;

class TestAddTask {

	@Test
	void testAddNullTask() {
		TaskManager manager = new TaskManager();
		assertThrows(IllegalArgumentException.class, () -> {
			manager.addTask(null);
		});
	}

	@Test
	void testAddOneTask() {
		TaskManager manager = new TaskManager();
		Task task1 = new Task("Title", "Description");
		manager.addTask(task1);
		assertEquals(1, manager.getSize(), "checking the number of task in the task manager");
		assertEquals("Title", manager.getTask().get(0).getTitle(),
				"checking the title of the task in the task manager");
		assertEquals("Description", manager.getTask().get(0).getDescription(),
				"checking the description of the task in the task manager");
	}

	@Test
	void testAddTwoTask() {
		TaskManager manager = new TaskManager();
		Task task1 = new Task("Title", "Description");
		manager.addTask(task1);
		Task task2 = new Task("Title2", "Description2");
		manager.addTask(task2);
		assertEquals(2, manager.getSize(), "checking the number of tasks in the task manager");
		assertEquals("Title", manager.getTask().get(0).getTitle(),
				"checking the title of the first task in the task manager");
		assertEquals("Description", manager.getTask().get(0).getDescription(),
				"checking the description of the first task in the task manager");
		assertEquals("Title2", manager.getTask().get(1).getTitle(),
				"checking the title of the second task in the task manager");
		assertEquals("Description2", manager.getTask().get(1).getDescription(),
				"checking the description of the second task in the task manager");
	}

}
