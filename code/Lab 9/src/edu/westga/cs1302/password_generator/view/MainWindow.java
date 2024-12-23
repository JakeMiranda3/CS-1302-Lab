package edu.westga.cs1302.password_generator.view;

import edu.westga.cs1302.password_generator.viewmodel.ViewModel;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Codebehind for the MainWindow of the Application.
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class MainWindow {

	@FXML
	private MenuItem about;
	@FXML
	private MenuItem close;
	@FXML
	private AnchorPane guiPane;
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
	private Label errorTextLabel;
	@FXML
	private Button generatePasswordButton;

	private ViewModel vm;

	@FXML
	void initialize() {
		this.vm = new ViewModel();
		this.vm.getRequireDigits().bind(this.mustIncludeDigits.selectedProperty());
		this.vm.getRequireLowercase().bind(this.mustIncludeLowerCaseLetters.selectedProperty());
		this.vm.getRequireUppercase().bind(this.mustIncludeUpperCaseLetters.selectedProperty());
		this.minimumLength.setText(this.vm.getMinimumLength().getValue());
		this.vm.getMinimumLength().bind(this.minimumLength.textProperty());

		this.output.textProperty().bind(this.vm.getPassword());
		this.errorTextLabel.textProperty().bind(this.vm.getErrorText());
		this.setUpEnablingOfControls();

		this.generatePasswordButton.setOnAction((event) -> {
			this.vm.generatePassword();
		});

		this.about.setOnAction((event) -> {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information");
			alert.setHeaderText("Project Purpose");
			alert.setContentText(
					"The purpose of this project is to generate a random password with conditions chosen by the user."
							+ System.lineSeparator() + System.lineSeparator() + "By Jake Miranda");
			alert.showAndWait();

		});

		this.close.setOnAction((event) -> {
			Stage stage = (Stage) (this.guiPane).getScene().getWindow();
			stage.close();
		});

	}

	private void setUpEnablingOfControls() {

		this.generatePasswordButton.disableProperty().bind(this.minimumLength.textProperty().isEmpty());

	}
}
