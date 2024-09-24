package edu.westga.cs1302.project1.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * Codebehind for the Main Window of the application.
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class MainWindow {

	@FXML
	private ComboBox<?> foodType;

	@FXML
	private TextField name;

	@FXML
	private ListView<?> pantryList;

	@FXML
	void addFood(ActionEvent event) {

	}

	@FXML
	void initialize() {
		assert this.foodType != null : "fx:id=\"foodType\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.name != null : "fx:id=\"name\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.pantryList != null
				: "fx:id=\"pantryList\" was not injected: check your FXML file 'MainWindow.fxml'.";

	}
}