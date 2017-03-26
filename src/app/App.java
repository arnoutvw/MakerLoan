package app;

import administration.Course;
import administration.Department;
import hr.Person;
import inventory.Item;
import inventory.Loan;
import storage.DataSerializer;

public class App {
	
	public static void main(String[] args) {
//		Department it = new Department("Informasjonsteknologi", "IT");
//		Course oop = new GradedCourse("Objektorientert programmering", "OOP", it);
//		new GradedCourse("Databaser", "DB", it);
//		
//		Student me = new Student("Kim Roar Stenvard", "Dehli", "46828919", it, Arrays.asList(new Course[]{oop}));
//		Employee teach = new AcademicEmployee("Per", "Bisseberg", "00000000", it);
//		Student bear = new Student("Bjørnar", "Hagen", "00000000", it, Arrays.asList(new Course[]{oop}));
//		
//		Item arduino = new Item("Arduino");
//		Item printer3D = new Item("3D Printer");
//		new Loan(arduino, me, new GregorianCalendar(2017, 2, 4));
//		new Loan(arduino, teach, new GregorianCalendar(2017, 1, 12));
//		new Loan(printer3D, me, new GregorianCalendar(2016, 11, 6));
//		new Loan(printer3D, bear);
		

		DataSerializer.add(Department.getDepartments(), System.getProperty("user.dir") + "\\departments.ser");
		DataSerializer.add(Course.getCourses(), System.getProperty("user.dir") + "\\courses.ser");
		DataSerializer.add(Person.getPersons(), System.getProperty("user.dir") + "\\persons.ser");
		DataSerializer.add(Item.getItems(), System.getProperty("user.dir") + "\\items.ser");
		DataSerializer.add(Loan.getLoans(), System.getProperty("user.dir") + "\\loans.ser");

		DataSerializer.deserializeAll();
		
		gui.MainFrame.main(new String[0]);
	}
	
	

}