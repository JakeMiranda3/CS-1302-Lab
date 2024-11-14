package edu.westga.cs1302.password_generator.test.viewmodel.viewmodel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.password_generator.viewmodel.ViewModel;

class TestGeneratePassword {

	@Test
	void testMinimumLengthNotANumber() {
		ViewModel vm = new ViewModel();
		vm.getMinimumLength().setValue("apple");
		vm.generatePassword();
		assertEquals(0, vm.getPastPasswords().size(), "checking the list property size");
		assertEquals("Invalid Minimum Length: must be a positive integer, but was apple", vm.getErrorText().getValue(),
				"checking the error text property");
	}

	@Test
	void testMinimumLengthNotAValidNumber() {
		ViewModel vm = new ViewModel();
		vm.getMinimumLength().setValue("-2");
		vm.generatePassword();
		assertEquals(0, vm.getPastPasswords().size(), "checking the list property size");
		assertEquals("Invalid Minimum Length: minimum length must be at least 1", vm.getErrorText().getValue(),
				"checking the error text property");
	}

	@Test
	void testValidInputProvided() {
		ViewModel vm = new ViewModel();
		vm.getMinimumLength().setValue("2");
		vm.generatePassword();
		assertTrue(vm.getPastPasswords().getValue().get(0).length() >= 2,
				"checking the password property has an appropriate number of characters");
		assertTrue(vm.getPastPasswords().getValue().size() == 1, "Checking the list property size");
		assertEquals("", vm.getErrorText().getValue(), "checking the error text property");
	}

	@Test
	void testMultipleValidInputsProvided() {
		ViewModel vm = new ViewModel();
		vm.getMinimumLength().setValue("2");
		vm.generatePassword();
		vm.getMinimumLength().setValue("3");
		vm.generatePassword();
		assertTrue(vm.getPastPasswords().getValue().get(0).length() >= 3,
				"checking the password property has an appropriate number of characters");
		assertTrue(vm.getPastPasswords().getValue().get(1).length() >= 2,
				"checking the password property has an appropriate number of characters");
		assertTrue(vm.getPastPasswords().getValue().size() == 2, "Checking the list property size");
		assertEquals("", vm.getErrorText().getValue(), "checking the error text property");
	}

}
