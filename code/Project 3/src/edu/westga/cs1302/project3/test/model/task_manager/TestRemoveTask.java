package edu.westga.cs1302.project3.test.model.task_manager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project3.model.Task;
import edu.westga.cs1302.project3.model.TaskManager;

class TestRemoveTask {

	@Test
	void testRemoveNullTask() {
		TaskManager manager = new TaskManager();
		assertThrows(IllegalArgumentException.class, () -> {
			manager.removeTask(null);
		});
	}

	@Test
	void testRemoveOneTask() {
		TaskManager manager = new TaskManager();
		Task task1 = new Task("Title", "Description");
		manager.addTask(task1);
		assertEquals(1, manager.getSize(), "checking the number of task in task manager");
		manager.removeTask(task1);
		assertEquals(0, manager.getSize(), "checking the number of task in task manager after removing");
	}

	@Test
	void TestRemoveTwoTask() {
		TaskManager manager = new TaskManager();
		Task task1 = new Task("Title", "Description");
		manager.addTask(task1);
		Task task2 = new Task("Title2", "Description2");
		manager.addTask(task2);
		assertEquals(2, manager.getSize(), "checking the number of task in task manager before removing any task");
		manager.removeTask(task1);
		assertEquals(1, manager.getSize(), "checking the number of task in task manager after removing one task");
		manager.removeTask(task2);
		assertEquals(0, manager.getSize(), "checking the number of task in task manager after removing two task");
	}

}
