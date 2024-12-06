package edu.westga.cs1302.project3.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import edu.westga.cs1302.project3.Main;
import edu.westga.cs1302.project3.model.Task;
import edu.westga.cs1302.project3.viewmodel.ViewModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Modality;
import javafx.stage.Stage;

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
	private MenuItem saveTask;
	@FXML
	private Button addTaskButton;
	@FXML
	private Button removeTask;

	@FXML
	private ViewModel vm;

	@FXML
	void initialize() {
		this.vm = new ViewModel();
		this.listOfTask.setItems(this.vm.getTasks());

		this.vm.getSelectedTask().bind(this.listOfTask.getSelectionModel().selectedItemProperty());
		this.loadTaskFile();
		this.saveTaskFile();

		this.removeTask.setOnAction((event) -> {
			try {
				this.vm.removeTask();
			} catch (IllegalArgumentException error) {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setContentText("Please select a task to remove.");
				alert.showAndWait();
			}
		});

		this.addTaskButton.setOnAction((event) -> {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource(Main.TASK_GUI_RESOURCE));
			try {
				loader.load();
				Parent parent = loader.getRoot();
				Scene scene = new Scene(parent);
				Stage setAddTaskStage = new Stage();
				setAddTaskStage.setTitle(Main.TASK_WINDOW_TITLE);
				setAddTaskStage.setScene(scene);
				setAddTaskStage.initModality(Modality.APPLICATION_MODAL);
				AddTaskWindow addTaskCodebehind = (AddTaskWindow) loader.getController();
				addTaskCodebehind.bindToVM(this.vm);
				setAddTaskStage.showAndWait();
			} catch (IOException error) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setContentText("Unable to load add task window. ");
				alert.showAndWait();
			}
		});
	}

	private void loadTaskFile() {
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

	private void saveTaskFile() {
		this.saveTask.setOnAction((event) -> {
			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("Save Task File");
			fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Text Files", "*.txt", "*.pdf"),
					new ExtensionFilter("All Files", "*.*"));
			File selectedFile = fileChooser.showSaveDialog(null);
			if (selectedFile != null) {
				try {
					this.vm.saveTaskManagerData(selectedFile.getAbsolutePath());
				} catch (IllegalArgumentException error) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setContentText(error.getMessage());
					alert.showAndWait();
				} catch (SecurityException error) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setContentText(error.getMessage());
					alert.showAndWait();
				} catch (IOException error) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setHeaderText("Unable to save task");
					alert.setContentText("Unable to retrieve file path, please select a new file");
				}
			}
		});
	}

}
