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
		Student bear = new Student("Bjørnar", "Hagen", "00000000", it, Arrays.asList(new Course[]{oop}));
		
		Item arduino = new Item("Arduino");
		Item printer3D = new Item("3D Printer");
		new Loan(arduino, me, new GregorianCalendar(2017, 2, 4));
		new Loan(arduino, teach, new GregorianCalendar(2017, 1, 12));
		new Loan(printer3D, me, new GregorianCalendar(2016, 11, 6));
		new Loan(printer3D, bear);
		
		
		gui.MainFrame.main(new String[0]);
	}

}