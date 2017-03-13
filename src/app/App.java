package app;

import java.util.Arrays;
import java.util.GregorianCalendar;

import administration.Course;
import administration.Department;
import administration.GradedCourse;
import hr.AcademicEmployee;
import hr.Employee;
import hr.Student;
import inventory.Item;
import inventory.Loan;

public class App {
	
	public static void main(String[] args) {
		Department it = new Department("Informasjonsteknologi", "IT");
		Course oop = new GradedCourse("Objektorientert programmering", "OOP", it);
		new GradedCourse("Databaser", "DB", it);
		
		Student me = new Student("Kim Roar Stenvard", "Dehli", "46828919", it, Arrays.asList(new Course[]{oop}));
		Employee teach = new AcademicEmployee("Per", "Bisseberg", "00000000", it);
		
		Item arduino = new Item("Arduino");
		new Loan(arduino, me, new GregorianCalendar(2017, 1, 4));
		new Loan(arduino, teach, new GregorianCalendar(2017, 2, 12));
		
		gui.MainFrame.main(new String[0]);
	}

}