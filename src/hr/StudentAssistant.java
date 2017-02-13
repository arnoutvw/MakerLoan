package hr;

import administration.Course;
import administration.Department;

public class StudentAssistant extends Student {
	// Constructors
	public StudentAssistant(String name, String surName, String phone, Department department, Course course) {
		super(name, surName, phone, department, course);
	}
	
	public StudentAssistant(Person person, String studentID, Course course) {
		super(person, course);
	}

	public StudentAssistant(Student student) {
		super(student);
	}

	// Methods
	
}
