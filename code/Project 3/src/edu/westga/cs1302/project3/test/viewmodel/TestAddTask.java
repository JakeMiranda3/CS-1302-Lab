package edu.westga.cs1302.project3.test.viewmodel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project3.viewmodel.ViewModel;

class TestAddTask {

	@Test
	void testAddTaskWithEmptyTaskTitle() {
		ViewModel vm = new ViewModel();
		vm.getTaskTitle().setValue("");
		vm.getTaskDescription().setValue("Test Description");
		assertThrows(IllegalArgumentException.class, () -> {
			vm.addTask();

		});
	}

	@Test
	void testAddTaskWithEmptyTaskDescription() {
		ViewModel vm = new ViewModel();
		vm.getTaskTitle().setValue("Test");
		vm.getTaskDescription().setValue("");
		assertThrows(IllegalArgumentException.class, () -> {
			vm.addTask();

		});
	}

	@Test
	void testAddTaskWithNullTaskTitle() {
		ViewModel vm = new ViewModel();
		vm.getTaskTitle().setValue(null);
		vm.getTaskDescription().setValue("Test Description");
		assertThrows(IllegalArgumentException.class, () -> {
			vm.addTask();

		});
	}

	@Test
	void testAddTaskWithNullTaskDescription() {
		ViewModel vm = new ViewModel();
		vm.getTaskTitle().setValue("Test");
		vm.getTaskDescription().setValue(null);
		assertThrows(IllegalArgumentException.class, () -> {
			vm.addTask();

		});
	}

	@Test
	void testAddTaskWithValidTask() {
		ViewModel vm = new ViewModel();
		vm.getTaskTitle().setValue("Test");
		vm.getTaskDescription().setValue("Test Description");
		vm.addTask();
		assertEquals(3, vm.getTasks().size(), "Checks the size of the list");
		assertEquals("Test", vm.getTasks().get(2).getTitle(), "checks the title of the new task");
		assertEquals("Test Description", vm.getTasks().get(2).getDescription(),
				"Checks the description of the new task");

	}

	@Test
	void testAddTaskWithTwoValidTask() {
		ViewModel vm = new ViewModel();
		vm.getTaskTitle().setValue("Test");
		vm.getTaskDescription().setValue("Test Description");
		vm.addTask();
		vm.getTaskTitle().setValue("Test 2");
		vm.getTaskDescription().setValue("Test Description 2");
		vm.addTask();
		assertEquals(4, vm.getTasks().size(), "Checks the size of the list");
		assertEquals("Test", vm.getTasks().get(2).getTitle(), "checks the title of the new task");
		assertEquals("Test Description", vm.getTasks().get(2).getDescription(),
				"Checks the description of the new task");
		assertEquals("Test 2", vm.getTasks().get(3).getTitle(), "checks the title of the new task");
		assertEquals("Test Description 2", vm.getTasks().get(3).getDescription(),
				"Checks the description of the new task");

	}

}
