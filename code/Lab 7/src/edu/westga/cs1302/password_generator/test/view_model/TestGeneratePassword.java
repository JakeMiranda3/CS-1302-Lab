package edu.westga.cs1302.password_generator.test.view_model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.password_generator.viewmodel.MainWindowViewModel;

class TestGeneratePassword {

	@Test
	void testWhenLengthIsLessThanZero() {
		MainWindowViewModel generate = new MainWindowViewModel();
		generate.lengthProperty().setValue("-1");
		generate.generatePassword();
		String result = generate.errorText().getValue();
		assertEquals("Error: Invalid Minimum Length: minimum length must be at least 1", result);

	}

	@Test
	void testWhenLengthIsZero() {
		MainWindowViewModel generate = new MainWindowViewModel();
		generate.lengthProperty().setValue("0");
		generate.generatePassword();
		String result = generate.errorText().getValue();
		assertEquals("Error: Invalid Minimum Length: minimum length must be at least 1", result);

	}

	@Test
	void testWhenLengthIsNotAInteger() {
		MainWindowViewModel generate = new MainWindowViewModel();
		generate.lengthProperty().setValue("A");
		generate.generatePassword();
		String result = generate.errorText().getValue();
		assertEquals("Error: Invalid Minimum Length: must be a positive integer, but was "
				+ generate.lengthProperty().getValue() + ".", result);

	}

	@Test
	void testMinimumLength1NoOtherRestriction() {
		MainWindowViewModel generate = new MainWindowViewModel();
		generate.lengthProperty().setValue("1");
		generate.digitProperty().setValue(false);
		generate.upperCaseProperty().setValue(false);
		generate.lowerCaseProperty().setValue(false);
		generate.generatePassword();
		String result = generate.outputProperty().getValue();
		assertTrue(1 <= result.length(), "checking length of generated password");

	}

	@Test
	void testMinimumLength3NoOtherRestriction() {
		MainWindowViewModel generate = new MainWindowViewModel();
		generate.lengthProperty().setValue("3");
		generate.digitProperty().setValue(false);
		generate.upperCaseProperty().setValue(false);
		generate.lowerCaseProperty().setValue(false);
		generate.generatePassword();
		String result = generate.outputProperty().getValue();
		assertTrue(3 <= result.length(), "checking length of generated password");

	}

	@Test
	void testMinimumLength3AtLeastOneUpperCaseLetterNoOtherRestriction() {
		MainWindowViewModel generate = new MainWindowViewModel();
		generate.lengthProperty().setValue("3");
		generate.digitProperty().setValue(false);
		generate.upperCaseProperty().setValue(true);
		generate.lowerCaseProperty().setValue(false);
		generate.generatePassword();
		String result = generate.outputProperty().getValue();
		assertTrue(3 <= result.length(), "checking length of generated password");
	}

	@Test
	void testMinimumLength3AtLeastOneDigitNoOtherRestriction() {
		MainWindowViewModel generate = new MainWindowViewModel();
		generate.lengthProperty().setValue("3");
		generate.digitProperty().setValue(true);
		generate.upperCaseProperty().setValue(false);
		generate.lowerCaseProperty().setValue(false);
		generate.generatePassword();
		String result = generate.outputProperty().getValue();
		assertTrue(3 <= result.length(), "checking length of generated password");
	}

	@Test
	void testMinimumLength3AtLeastOneLowerCaseLetterNoOtherRestriction() {
		MainWindowViewModel generate = new MainWindowViewModel();
		generate.lengthProperty().setValue("3");
		generate.digitProperty().setValue(false);
		generate.upperCaseProperty().setValue(false);
		generate.lowerCaseProperty().setValue(true);
		generate.generatePassword();
		String result = generate.outputProperty().getValue();
		assertTrue(3 <= result.length(), "checking length of generated password");
	}

	@Test
	void testMinimumLength3AtLeastOneLowerCaseLetterAtLeastOneUpperCaseLetterNoOtherRestriction() {
		MainWindowViewModel generate = new MainWindowViewModel();
		generate.lengthProperty().setValue("3");
		generate.digitProperty().setValue(false);
		generate.upperCaseProperty().setValue(true);
		generate.lowerCaseProperty().setValue(true);
		generate.generatePassword();
		String result = generate.outputProperty().getValue();
		assertTrue(3 <= result.length(), "checking length of generated password");
	}

	@Test
	void testMinimumLength3AtLeastOneLowerCaseLetterAtLeastOneDigitNoOtherRestriction() {
		MainWindowViewModel generate = new MainWindowViewModel();
		generate.lengthProperty().setValue("3");
		generate.digitProperty().setValue(true);
		generate.upperCaseProperty().setValue(false);
		generate.lowerCaseProperty().setValue(true);
		generate.generatePassword();
		String result = generate.outputProperty().getValue();
		assertTrue(3 <= result.length(), "checking length of generated password");
	}

	@Test
	void testMinimumLength3AtLeastOneUpperCaseLetterAtLeastOneDigitNoOtherRestriction() {
		MainWindowViewModel generate = new MainWindowViewModel();
		generate.lengthProperty().setValue("3");
		generate.digitProperty().setValue(true);
		generate.upperCaseProperty().setValue(true);
		generate.lowerCaseProperty().setValue(false);
		generate.generatePassword();
		String result = generate.outputProperty().getValue();
		assertTrue(3 <= result.length(), "checking length of generated password");
	}

	@Test
	void testMinimumLength3AtLeastOneUpperCaseLetterAtLeastOneLowerCaseLetterAtLeastOneDigit() {
		MainWindowViewModel generate = new MainWindowViewModel();
		generate.lengthProperty().setValue("3");
		generate.digitProperty().setValue(true);
		generate.upperCaseProperty().setValue(true);
		generate.lowerCaseProperty().setValue(true);
		generate.generatePassword();
		String result = generate.outputProperty().getValue();
		assertTrue(3 <= result.length(), "checking length of generated password");
	}

}
