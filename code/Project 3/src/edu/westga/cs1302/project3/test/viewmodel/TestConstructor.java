package edu.westga.cs1302.project3.test.viewmodel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project3.viewmodel.ViewModel;

class TestConstructor {

	@Test
	void testConstructor() {
		ViewModel vm = new ViewModel();
		assertEquals(2, vm.getTasks().getSize(), "Checks the amount of task when initialized");
		assertEquals("Default Task 1", vm.getTasks().get(0).getTitle(), "checks the title of the task");
		assertEquals("First task", vm.getTasks().get(0).getDescription(), "checks the description of the task");
		assertEquals("Default Task 2", vm.getTasks().get(1).getTitle(), "checks the title of the task");
		assertEquals("Second task", vm.getTasks().get(1).getDescription(), "checks the description of the task");
	}
}
