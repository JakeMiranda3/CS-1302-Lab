package edu.westga.cs1302.password_generator.viewmodel;

import java.util.Random;

import edu.westga.cs1302.password_generator.model.PasswordGenerator;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * The class View Model
 * 
 * @author Jake Miranda
 * @version Fall 2024
 */
public class MainWindowViewModel {
	private StringProperty lengthProperty;
	private StringProperty outputProperty;
	private BooleanProperty digitProperty;
	private BooleanProperty lowerCaseProperty;
	private BooleanProperty upperCaseProperty;
	private StringProperty errorText;

	/**
	 * Instantiates a new main window view model
	 */
	public MainWindowViewModel() {
		this.lengthProperty = new SimpleStringProperty("1");
		this.outputProperty = new SimpleStringProperty("");
		this.digitProperty = new SimpleBooleanProperty();
		this.lowerCaseProperty = new SimpleBooleanProperty();
		this.upperCaseProperty = new SimpleBooleanProperty();
		this.errorText = new SimpleStringProperty("Error: ");

	}

	/**
	 * Gets the length property.
	 * 
	 * @return the lengthProperty.
	 */
	public StringProperty lengthProperty() {
		return this.lengthProperty;
	}

	/**
	 * Gets the output property.
	 * 
	 * @return the outputProperty.
	 */
	public StringProperty outputProperty() {
		return this.outputProperty;
	}

	/**
	 * Gets the digit property.
	 * 
	 * @return the digitProperty.
	 */
	public BooleanProperty digitProperty() {
		return this.digitProperty;
	}

	/**
	 * Gets the lower case Property.
	 * 
	 * @return the lowerCaseProperty.
	 */
	public BooleanProperty lowerCaseProperty() {
		return this.lowerCaseProperty;
	}

	/**
	 * Gets the upper case Property.
	 * 
	 * @return the upperCaseProperty.
	 */
	public BooleanProperty upperCaseProperty() {
		return this.upperCaseProperty;
	}

	/**
	 * Gets the error text property.
	 * 
	 * @return the errorText.
	 */
	public StringProperty errorText() {
		return this.errorText;
	}

	/**
	 * Generates a password according to the established requirements from the user
	 */
	public void generatePassword() {
		int minimumLength = -1;

		try {
			minimumLength = Integer.parseInt(this.lengthProperty.getValue());
		} catch (NumberFormatException numberError) {
			this.errorText.setValue("Error: Invalid Minimum Length: must be a positive integer, but was "
					+ this.lengthProperty.getValue());
			return;
		}
		try {
			Random randomNumberGenerator = new Random();
			PasswordGenerator password = new PasswordGenerator(randomNumberGenerator.nextLong());
			password.setMinimumLength(minimumLength);
			password.setMustHaveAtLeastOneDigit(this.digitProperty.getValue());
			password.setMustHaveAtLeastOneUpperCaseLetter(this.upperCaseProperty.getValue());
			password.setMustHaveAtLeastOneLowerCaseLetter(this.lowerCaseProperty.getValue());
			String passwordText = password.generatePassword();
			this.outputProperty.set(passwordText);

		} catch (IllegalArgumentException invalidLengthError) {
			this.errorText.setValue("Error: Invalid Minimum Length: " + invalidLengthError.getMessage());
			return;
		}

	}

}
