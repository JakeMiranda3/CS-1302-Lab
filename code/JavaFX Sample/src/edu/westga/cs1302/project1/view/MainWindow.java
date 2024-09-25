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
	private TextField count;

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
		Food food = this.pantryList.getSelectionModel().getSelectedItem();
		String foodQuantity = this.quantity.getText();
		if (food != null) {
			try {
				food.setQuantity(Integer.parseInt(foodQuantity));
				this.pantryList.refresh();
			} catch (IllegalArgumentException errorObject) {
				Alert errorPopup = new Alert(Alert.AlertType.ERROR);
				errorPopup.setContentText("Unable to set quantity: " + errorObject.getMessage()
						+ " Please enter a non-negative number and try again.");
				errorPopup.showAndWait();
			}
		} else {
			Alert errorPopup = new Alert(Alert.AlertType.ERROR);
			errorPopup.setContentText("No food selected. Unable to set quantity.");
			errorPopup.showAndWait();

		}

	}

	@FXML
	void decreaseQuantity(ActionEvent event) {
		Food food = this.pantryList.getSelectionModel().getSelectedItem();
		if (food != null) {
			try {
				food.decreaseQuantity();
				this.pantryList.refresh();
			} catch (IllegalArgumentException errorObject) {
				Alert errorPopup = new Alert(Alert.AlertType.ERROR);
				errorPopup.setContentText("Unable to decrease quantity: " + errorObject.getMessage());
				errorPopup.showAndWait();
			}
		} else {
			Alert errorPopup = new Alert(Alert.AlertType.ERROR);
			errorPopup.setContentText("No food selected. Unable to decrease quantity.");
			errorPopup.showAndWait();

		}

	}

	@FXML
	void increaseQuantity(ActionEvent event) {
		Food food = this.pantryList.getSelectionModel().getSelectedItem();
		if (food != null) {
			food.increaseQuantity();
			this.pantryList.refresh();
		} else {
			Alert errorPopup = new Alert(Alert.AlertType.ERROR);
			errorPopup.setContentText("No food selected. Unable to increase quantity.");
			errorPopup.showAndWait();

		}
	}

	@FXML
	void removeFood(ActionEvent event) {
		Food food = this.pantryList.getSelectionModel().getSelectedItem();
		if (food != null) {
			this.pantryList.getItems().remove(food);
		} else {
			Alert errorPopup = new Alert(Alert.AlertType.ERROR);
			errorPopup.setContentText("No food selected. Unable to remove.");
			errorPopup.showAndWait();
		}

	}

	@FXML
	void countPantry(ActionEvent event) {

	}

	@FXML
	void initialize() {
		this.type.getItems().addAll("Vegetable", "Meat", "Bread", "Fruit", "Dessert", "Ingredient");
		assert this.type != null : "fx:id=\"foodType\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.name != null : "fx:id=\"name\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.pantryList != null
				: "fx:id=\"pantryList\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.quantity != null : "fx:id=\"quantity\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.count != null : "fx:id=\"count\" was not injected: check your FXML file 'MainWindow.fxml'.";

	}
}