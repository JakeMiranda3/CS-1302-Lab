package edu.westga.cs1302.project3.view;

import edu.westga.cs1302.project3.viewmodel.ViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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

	/**
	 * Sets up the binding for ViewModel and AddTaskWindow
	 * 
	 * @param vm The view Model
	 */
	public void bindToVM(ViewModel vm) {

		this.closeWindow.setOnAction((event) -> {
			Stage stage = (Stage) (this.guiTaskPane).getScene().getWindow();
			stage.close();
		});

	}

}
