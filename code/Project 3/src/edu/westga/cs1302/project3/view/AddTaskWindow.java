package edu.westga.cs1302.project3.view;

import edu.westga.cs1302.project3.viewmodel.ViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Codebehind for the Add Task Window of the application.
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class AddTaskWindow {
	@FXML
	private Button closeWindow;

	@FXML
	private AnchorPane guiTaskPane;

	@FXML
	private TextArea taskDescription;

	@FXML
	private TextField taskTitle;

	@FXML
	private Button addTask;

	/**
	 * Sets up the binding for ViewModel and AddTaskWindow
	 * 
	 * @param vm The view Model
	 */
	public void bindToVM(ViewModel vm) {
		vm.getTaskTitle().bind(this.taskTitle.textProperty());
		vm.getTaskDescription().bind(this.taskDescription.textProperty());

		this.closeWindow.setOnAction((event) -> {
			Stage stage = (Stage) (this.guiTaskPane).getScene().getWindow();
			stage.close();
		});

		this.addTask.setOnAction((event) -> {
			try {
				vm.addTask();
				Stage stage = (Stage) (this.guiTaskPane).getScene().getWindow();
				stage.close();
			} catch (IllegalArgumentException error) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setContentText(error.getMessage());
				alert.showAndWait();

			}

		});

	}

}
