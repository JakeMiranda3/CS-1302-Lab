package edu.westga.cs1302.project3;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Entry point for the program​ ​
 * 
 * @author CS1302​
 * @version Fall 2024​
 */
public class Main extends Application {

	public static final String TASK_GUI_RESOURCE = "view/AddTaskWindow.fxml";
	public static final String TASK_WINDOW_TITLE = "Add Task";
	private static final String WINDOW_TITLE = "Project 3";
	private static final String GUI_RESOURCE = "view/MainWindow.fxml";

	/**
	 * JavaFX entry point.​ ​
	 * 
	 * @precondition none​
	 * @postcondition none​ ​
	 * @throws IOException unable to load fxml for MainWindow​
	 */
	@Override
	public void start(Stage primaryStage) throws IOException {
		Parent parent = FXMLLoader.load(getClass().getResource(Main.GUI_RESOURCE));
		Scene scene = new Scene(parent);
		primaryStage.setTitle(Main.WINDOW_TITLE);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	/**
	 * Primary Java entry point.​ ​
	 * 
	 * @precondition none​
	 * @postcondition none​ ​
	 * @param args command line arguments​
	 */
	public static void main(String[] args) {
		Main.launch(args);
	}

}
