package hr;

import administration.Department;

public class AdminEmployee extends Employee {
	// Constructors
	public AdminEmployee(String name, String surName, String phone, Department department) {
		super(name, surName, phone, department);
	}

	public AdminEmployee(String name, String surName, String phone) {
		super(name, surName, phone);
	}

	public AdminEmployee(String name, String surName) {
		super(name, surName);
	}
	
	public AdminEmployee(Person person) {
		super(person);
	}

}
