package hr;

import administration.Department;

public class AcademicEmployee extends Employee {
	// Constructors
	public AcademicEmployee(String name, String surName, String phone, Department department) {
		super(name, surName, phone, department);
		// TODO Auto-generated constructor stub
	}

	public AcademicEmployee(String name, String surName, String phone) {
		super(name, surName, phone);
	}

	public AcademicEmployee(String name, String surName) {
		super(name, surName);
	}
	
	public AcademicEmployee(Person person) {
		super(person);
	}

	
}
