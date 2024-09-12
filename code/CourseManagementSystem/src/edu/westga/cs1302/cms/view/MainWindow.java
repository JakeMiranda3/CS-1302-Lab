package edu.westga.cs1302.cms.view;

import java.util.ArrayList;

import edu.westga.cs1302.cms.model.AverageCalculator;
import edu.westga.cs1302.cms.model.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * Code behind for the MainWindow of the application
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class MainWindow {

	@FXML
	private TextField grade;
	@FXML
	private TextField name;
	@FXML
	private ListView<Student> students;
	@FXML
	private TextField studentGrade;
	@FXML
	private TextField studentAverage;

	@FXML
	void addStudent(ActionEvent event) {
		String studentName = this.name.getText();
		try {
			double grade = Double.parseDouble(this.grade.getText());
			Student student = new Student(studentName, grade);
			this.students.getItems().add(student);
			this.studentAverage.clear();
			ArrayList<Student> studentsInfo = new ArrayList<Student>(this.students.getItems());
			this.studentAverage.appendText(AverageCalculator.calculateAverage(studentsInfo));
		} catch (NumberFormatException errorNum) {
			Alert errorPopup = new Alert(Alert.AlertType.ERROR);
			errorPopup.setContentText(
					"Unable to create student: " + errorNum.getMessage() + " Please reenter grade and try again.");
			errorPopup.showAndWait();
		} catch (IllegalArgumentException errorObject) {
			Alert errorPopup = new Alert(Alert.AlertType.ERROR);
			errorPopup.setContentText("Unable to create student: " + errorObject.getMessage()
					+ " Please reenter name and grade, then try again.");
			errorPopup.showAndWait();
		}

	}

	@FXML
	void removeStudent(ActionEvent event) {
		Student student = this.students.getSelectionModel().getSelectedItem();
		if (student != null) {
			this.students.getItems().remove(student);
			this.studentAverage.clear();
			ArrayList<Student> studentsInfo = new ArrayList<Student>(this.students.getItems());
			this.studentAverage.appendText(AverageCalculator.calculateAverage(studentsInfo));
		} else {
			Alert errorPopup = new Alert(Alert.AlertType.ERROR);
			errorPopup.setContentText("No student selected. Unable to remove.");
			errorPopup.showAndWait();

		}

	}

	@FXML
	void checkGrade(ActionEvent event) {
		Student student = this.students.getSelectionModel().getSelectedItem();
		if (student != null) {
			this.studentGrade.clear();
			double grade = student.getGrade();
			String gradeStudent = Double.toString(grade);
			this.studentGrade.appendText(gradeStudent);
		} else {
			Alert errorPopup = new Alert(Alert.AlertType.ERROR);
			errorPopup.setContentText("No student selected. Unable to grade.");
			errorPopup.showAndWait();

		}

	}

	@FXML
	void initialize() {
		assert this.grade != null : "fx:id=\"grade\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.name != null : "fx:id=\"name\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.students != null : "fx:id=\"students\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.studentGrade != null
				: "fx:id=\"studentGrade\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.studentAverage != null
				: "fx:id=\"studentAverage\" was not injected: check your FXML file 'MainWindow.fxml'.";

	}

}
