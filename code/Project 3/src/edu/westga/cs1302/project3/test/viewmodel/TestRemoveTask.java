package edu.westga.cs1302.project3.test.viewmodel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project3.model.Task;
import edu.westga.cs1302.project3.viewmodel.ViewModel;

class TestRemoveTask {

	@Test
	void testRemoveNullTask() {
		ViewModel vm = new ViewModel();
		assertThrows(IllegalArgumentException.class, () -> {
			vm.getSelectedTask().setValue(null);
			vm.removeTask();
		});
	}

	@Test
	void testRemoveOneTask() {
		ViewModel vm = new ViewModel();
		Task task = vm.getTasks().get(0);
		vm.getSelectedTask().setValue(task);
		vm.removeTask();
		assertEquals(1, vm.getTasks().getSize(), "Checks the size of the list");
		assertEquals("Default Task 2", vm.getTasks().get(0).getTitle(), "Checks the title of the task");
		assertEquals("Second task", vm.getTasks().get(0).getDescription(), "Checks the description of the task");

	}

	@Test
	void TestRemoveTwoTask() {
		ViewModel vm = new ViewModel();
		Task task = vm.getTasks().get(0);
		vm.getSelectedTask().setValue(task);
		vm.removeTask();
		Task task2 = vm.getTasks().get(0);
		vm.getSelectedTask().setValue(task2);
		vm.removeTask();
		assertEquals(0, vm.getTasks().getSize(), "Checks the size of the list");

	}

}
