package edu.westga.cs1302.cms.test.model.averagecalculator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.cms.model.AverageCalculator;
import edu.westga.cs1302.cms.model.Student;

class TestCalculateAverage {

	@Test
	void testCalculateAverageWhenTheresZeroStudents() {
		ArrayList<Student> students = new ArrayList<Student>();
		assertEquals("0.0", AverageCalculator.calculateAverage(students), "checks the average grade of the students");
		assertEquals(0, students.size(), "checks the size of the list of students");

	}

	@Test
	void testCalculateAverageWhenTheresOneStudent() {
		Student student1 = new Student("Jake", 100.0);
		ArrayList<Student> students = new ArrayList<Student>();
		students.add(student1);
		assertEquals(1, students.size(), "checks the size of the list of students");
		assertEquals("Jake", student1.getName(), "checks the name of the student");
		assertEquals(100.0, student1.getGrade(), "checks the grade of the student");
		assertEquals("100.0", AverageCalculator.calculateAverage(students), "checks the average grade of the students");

	}

	@Test
	void testCalculateAverageWhenTheresTwoStudents() {
		Student student1 = new Student("Jake", 100.0);
		Student student2 = new Student("Jonathan", 50.0);
		ArrayList<Student> students = new ArrayList<Student>();
		students.add(student1);
		students.add(student2);
		assertEquals(2, students.size(), "checks the size of the list of students");
		assertEquals("Jake", student1.getName(), "checks the name of the student");
		assertEquals("Jonathan", student2.getName(), "checks the name of the student");
		assertEquals(100.0, student1.getGrade(), "checks the grade of the student");
		assertEquals(50.0, student2.getGrade(), "checks the grade of the student");
		assertEquals("75.0", AverageCalculator.calculateAverage(students), "checks the average grade of the students");

	}

}
