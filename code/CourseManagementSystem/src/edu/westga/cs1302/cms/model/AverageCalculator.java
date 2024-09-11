package edu.westga.cs1302.cms.model;

import javafx.scene.control.ListView;

/**
 * Calculates the average of grades in the class
 * 
 * @author Jake Miranda
 * @version Fall 2024
 */
public class AverageCalculator {

	/**
	 * Takes in the ListView of students and calculates the average grade of
	 * students
	 * 
	 * @param students List of students
	 * @return Returns a double rounded to two decimal points
	 */
	public static String calculateAverage(ListView<Student> students) {
		double totalGrade = 0.00;
		double averageGrade = 0.00;
		for (Student student : students.getItems()) {
			totalGrade += student.getGrade();
		}
		averageGrade = (totalGrade / students.getItems().size());
		averageGrade = Math.round(averageGrade * 100.00) / 100.00;
		return Double.toString(averageGrade);
	}

}
