package edu.westga.cs1302.cms.test.model.student;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.cms.model.Student;

class TestConstructor {

	@Test
	void testNullName() {
		assertThrows(IllegalArgumentException.class, ()->{new Student(null,0);});
	}

	@Test
	void testNameTooShort() {
		assertThrows(IllegalArgumentException.class, ()->{new Student("12",0);});
	}
	
	@Test
	void testWhenGradeIsOneLessThanZero() {
		assertThrows(IllegalArgumentException.class, ()->{
			new Student("Student", -1);
		});
	}
	@Test
	void testWhenGradeIsZero() {
		Student student = new Student("Jake", 0);
		double result = student.getGrade();
		assertEquals(0, result, "checking the grade of the student");
	}
	
	@Test
	void testWhenGradeIsOneAboveZero() {
		Student student = new Student("Jake", 1);
		double result = student.getGrade();
		assertEquals(1, result, "checking the grade of the student");
	}
	
	@Test
	void testWhenGradeIsOneLessThanHundred() {
		Student student = new Student("Jake", 99);
		double result = student.getGrade();
		assertEquals(99, result, "checking the grade of the student");
		
	}
	@Test
	void testWhenGradeIsOneHundred() {
		Student student = new Student("Jake", 100);
		double result = student.getGrade();
		assertEquals(100, result, "checking the grade of the student");
	}
	@Test
	void testWhenGradeIsOneAboveHundred() {
		Student student = new Student("Jake", 101);
		double result = student.getGrade();
		assertEquals(101, result, "checking the grade of the student");
	}
	@Test
	void testMinimumLengthName() {
		Student result = new Student("123",2);
		
		assertEquals("123", result.getName(), "checking the name of the student");
		assertEquals(2, result.getGrade(), "checking the grade of the student");
	}

}
