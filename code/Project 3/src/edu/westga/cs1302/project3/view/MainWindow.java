package edu.westga.cs1302.project3.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import edu.westga.cs1302.project3.model.Task;
import edu.westga.cs1302.project3.viewmodel.ViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

/**
 * Codebehind for the Main Window of the application.
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class MainWindow {
	@FXML
	private ListView<Task> listOfTask;
	@FXML
	private MenuItem loadTask;

	@FXML
	private ViewModel vm;

	@FXML
	void initialize() {
		this.vm = new ViewModel();
		this.listOfTask.setItems(this.vm.getTasks());

		this.loadTask.setOnAction((event) -> {
			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("Open Task File");
			fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Text Files", "*.txt", "*.pdf"),
					new ExtensionFilter("All Files", "*.*"));
			File selectedFile = fileChooser.showOpenDialog(null);
			if (selectedFile != null) {
				try {
					this.vm.loadTaskManagerData(selectedFile.getAbsolutePath());
				} catch (IllegalArgumentException error) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setContentText(error.getMessage());
					alert.showAndWait();
				} catch (FileNotFoundException error) {
					Alert alert = new Alert(Alert.AlertType.ERROR);
					alert.setHeaderText("Unable to load task");
					alert.setContentText("File cannot be found.");
				} catch (IOException error) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setHeaderText("Unable to load task");
					alert.setContentText("Unable to retrieve file path, please select a new file");
					alert.showAndWait();
				}
			}

		});

	}

}
