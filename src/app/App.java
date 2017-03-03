package app;

import java.util.Arrays;

import administration.Course;
import administration.Department;
import administration.GradedCourse;
import hr.AcademicEmployee;
import hr.Student;

public class App {
	
	public static void main(String[] args) {
		Department it = new Department("Informasjonsteknologi", "IT");
		Course oop = new GradedCourse("Objektorientert programmering", "OOP", it);
		new Student("Kim Roar Stenvard", "Dehli", "46828919", it, Arrays.asList(new Course[]{oop}));
		new AcademicEmployee("Per", "Bisseberg", "???", it);
		gui.MainFrame.main(args);
	}

}