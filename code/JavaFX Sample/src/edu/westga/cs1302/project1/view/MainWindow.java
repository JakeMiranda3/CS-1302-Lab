package edu.westga.cs1302.project1.view;

import edu.westga.cs1302.project1.model.Food;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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
	private ComboBox<String> type;

	@FXML
	private TextField name;

	@FXML
	private ListView<Food> pantryList;

	@FXML
	private TextField quantity;

	@FXML
	void addFood(ActionEvent event) {
		String foodName = this.name.getText();
		String foodType = this.type.getValue();
		try {
			Food food = new Food(foodName, foodType);
			this.pantryList.getItems().add(food);
			this.name.clear();
		} catch (IllegalArgumentException errorObject) {
			Alert errorPopup = new Alert(Alert.AlertType.ERROR);
			errorPopup.setContentText("Unable to add food: " + errorObject.getMessage()
					+ " Please reenter name and select type, and try again.");
			errorPopup.showAndWait();
		}

	}

	@FXML
	void setQuantity(ActionEvent event) {

	}

	@FXML
	void decreaseQuantity(ActionEvent event) {

	}

	@FXML
	void increaseQuantity(ActionEvent event) {

	}

	@FXML
	void initialize() {
		this.type.getItems().addAll("Vegetable", "Meat", "Bread", "Fruit", "Dessert", "Ingredient");
		assert this.type != null : "fx:id=\"foodType\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.name != null : "fx:id=\"name\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.pantryList != null
				: "fx:id=\"pantryList\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.quantity != null : "fx:id=\"quantity\" was not injected: check your FXML file 'MainWindow.fxml'.";

	}
}