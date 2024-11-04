package edu.westga.cs1302.project2.view;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

import edu.westga.cs1302.project2.model.Ingredient;
import edu.westga.cs1302.project2.model.IngredientNameComparator;
import edu.westga.cs1302.project2.model.IngredientTypeComparator;
import edu.westga.cs1302.project2.model.Recipe;
import edu.westga.cs1302.project2.model.RecipeToFile;
import edu.westga.cs1302.project2.model.Utility;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * Codebehind for the Main Window of the application.
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class MainWindow {
	@FXML
	private ComboBox<String> ingredientType;
	@FXML
	private ListView<Ingredient> ingredientsList;
	@FXML
	private TextField ingredientName;
	@FXML
	private ComboBox<Comparator<Ingredient>> sort;

	@FXML
	private ListView<Ingredient> recipe;

	@FXML
	private TextField recipeName;
	
	@FXML
    private TextArea recipes;

	@FXML
	void addIngredient(ActionEvent event) {
		try {
			this.ingredientsList.getItems()
					.add(new Ingredient(this.ingredientName.getText(), this.ingredientType.getValue()));
			this.ingredientName.clear();
			this.ingredientType.getSelectionModel().clearSelection();
		} catch (IllegalArgumentException error) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText("Unable to add ingredient");
			alert.setContentText(error.getMessage());
			alert.showAndWait();
		}
		this.sortIngredients(null);
	}

	@FXML
	void removeIngredient(ActionEvent event) {
		Ingredient selectedIngredient = this.ingredientsList.getSelectionModel().getSelectedItem();
		if (selectedIngredient != null) {
			this.ingredientsList.getItems().remove(selectedIngredient);
		}
		this.sortIngredients(null);
	}

	@FXML
	void sortIngredients(ActionEvent event) {
		this.ingredientsList.getItems().sort(this.sort.getValue());
	}

	@FXML
	void addIngredientToRecipe(ActionEvent event) {
		Ingredient ingredient = this.ingredientsList.getSelectionModel().getSelectedItem();
		if (ingredient != null) {
			this.recipe.getItems().add(ingredient);
		} else {
			Alert errorPopup = new Alert(Alert.AlertType.ERROR);
			errorPopup.setContentText("No ingredient selected. Unable to add to recipe.");
			errorPopup.showAndWait();
		}
	}

	@FXML
	void addRecipe(ActionEvent event) {
		String name = this.recipeName.getText();
		ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
		for (Ingredient currIngredient : this.recipe.getItems()) {
			ingredients.add(currIngredient);
		}

		try {
			Recipe recipe = new Recipe(name, ingredients);
			Utility.recipeToString(recipe);
			RecipeToFile recipeFile = new RecipeToFile();
			recipeFile.writeRecipeToFile(recipe);
		} catch (IllegalArgumentException error) {
			Alert errorPopup = new Alert(Alert.AlertType.ERROR);
			errorPopup.setHeaderText("Unable to create recipe");
			errorPopup.setContentText(error.getMessage());
			errorPopup.showAndWait();
		} catch (IllegalStateException error) {
			Alert errorPopup = new Alert(Alert.AlertType.ERROR);
			errorPopup.setHeaderText("Unable to create recipe");
			errorPopup.setContentText(error.getMessage());
			errorPopup.showAndWait();
		} catch (FileNotFoundException error) {
			Alert errorPopup = new Alert(Alert.AlertType.ERROR);
			errorPopup.setHeaderText("Unable to create recipe");
			errorPopup.setContentText("File cannot be found.");
			errorPopup.showAndWait();
		} catch (IOException error) {
			Alert errorPopup = new Alert(Alert.AlertType.ERROR);
			errorPopup.setHeaderText("Unable to create recipe");
			errorPopup.setContentText("File does not exist or cannot be opened for any other reason.");
			errorPopup.showAndWait();
		}
		this.recipeName.clear();
		this.recipe.getItems().clear();

	}
	
    @FXML
    void displayRecipesWithIngredient(ActionEvent event) {

    }

	@FXML
	void initialize() {
		this.ingredientType.getItems().add("Vegetable");
		this.ingredientType.getItems().add("Meat");
		this.ingredientType.getItems().add("Bread");
		this.ingredientType.getItems().add("Fruit");
		this.ingredientType.getItems().add("Spice");

		this.sort.getItems().add(new IngredientTypeComparator());
		this.sort.getItems().add(new IngredientNameComparator());
		this.sort.setValue(this.sort.getItems().get(0));

	}
}
