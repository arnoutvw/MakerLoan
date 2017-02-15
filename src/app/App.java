package app;

import java.util.GregorianCalendar;

import administration.*;
import hr.*;
import inventory.*;

public class App {
	
	public static void main(String[] args) {
		Department it = new Department("Informasjonsteknologi", "IT");
		Course oop = new GradedCourse("Objektorientert programmering", "ITF10611", it);
		Student kim = new Student("Kim Roar Stenvard", "Dehli", "46828919", it);
		kim.getCourseList().add(oop);
		Item arduino = new Item("Arduino", 1, 1);
		Loan loan = new Loan(arduino, kim, new GregorianCalendar());
		 
		System.out.println(kim);
		System.out.println(arduino);
		System.out.println(it);
		System.out.println(oop);
		System.out.println(loan);
	}

}