package hr;

import administration.Department;

public class AcademicEmployee extends Employee {
	
	private static final long serialVersionUID = 1691927223297399889L;

	// Constructors
	public AcademicEmployee(String name, String surName, String phone, Department department) {
		super(name, surName, phone, department);
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
