package no.hiof.itstud.krdehli.makerloan.hr;

import java.util.ArrayList;

import no.hiof.itstud.krdehli.makerloan.administration.Course;
import no.hiof.itstud.krdehli.makerloan.administration.Department;

public class StudentAssistant extends Student {
	
	private static final long serialVersionUID = -5361046988891849740L;

	// Constructors
	public StudentAssistant(String name, String surName, String phone, Department department, ArrayList<Course> courseList) {
		super(name, surName, phone, department, courseList);
	}

	public StudentAssistant(String name, String surName, String phone, Department department) {
		super(name, surName, phone, department);
	}

	public StudentAssistant(String name, String surName, String phone) {
		super(name, surName, phone);
	}

	public StudentAssistant(String name, String surName) {
		super(name, surName);
	}
	
	public StudentAssistant(Person person, ArrayList<Course> courseList) {
		super(person, courseList);
	}

	public StudentAssistant(Person person) {
		super(person);
	}
	
	public StudentAssistant(Student student) {
		super(student);
	}
	
}
