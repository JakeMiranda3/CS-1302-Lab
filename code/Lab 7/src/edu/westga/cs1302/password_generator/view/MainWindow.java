package edu.westga.cs1302.password_generator.view;

import edu.westga.cs1302.password_generator.viewmodel.MainWindowViewModel;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * Codebehind for the MainWindow of the Application.
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class MainWindow {

	@FXML
	private CheckBox mustIncludeDigits;
	@FXML
	private CheckBox mustIncludeLowerCaseLetters;
	@FXML
	private CheckBox mustIncludeUpperCaseLetters;
	@FXML
	private TextField minimumLength;
	@FXML
	private TextArea output;
	@FXML
	private Label errorText;
	@FXML
	private Button generateButton;
	private MainWindowViewModel viewModel;

	/**
	 * Instantiates a new MainWindow code behind
	 */
	public MainWindow() {
		this.viewModel = new MainWindowViewModel();
	}

	@FXML
	void initialize() {
		this.bindComponentsToViewModel();

	}

	private void bindComponentsToViewModel() {
		this.errorText.textProperty().bind(this.viewModel.errorText());
		this.minimumLength.textProperty().bindBidirectional(this.viewModel.lengthProperty());
		this.output.textProperty().bind(this.viewModel.outputProperty());
		this.mustIncludeDigits.selectedProperty().bindBidirectional(this.viewModel.digitProperty());
		this.mustIncludeUpperCaseLetters.selectedProperty().bindBidirectional(this.viewModel.upperCaseProperty());
		this.mustIncludeLowerCaseLetters.selectedProperty().bindBidirectional(this.viewModel.lowerCaseProperty());
		this.generateButton.setOnAction((event) -> {
			this.viewModel.generatePassword();

		});
	}
}
