package no.hiof.itstud.krdehli.makerloan.hr;

import no.hiof.itstud.krdehli.makerloan.administration.Department;

public class AdminEmployee extends Employee {
	
	private static final long serialVersionUID = -7752776068762899809L;

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
