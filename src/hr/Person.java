package hr;

import administration.Department;

public class Person {
	// Fields
	private String name;
	private String surName;
	private String phone;
	private Department department;
	
	
	//Constructors
	public Person(String name, String surName, String phone, Department department) {
		verifyNames(name, surName);
		this.name = name;
		this.surName = surName;
		this.phone = phone;
		this.department = department;
	}
	
	public Person(String name, String surName, String phone) {
		this(name, surName, phone, null);
	}
	
	public Person(String name, String surName) {
		this(name, surName, null);
	}
	
	public Person(Person person) {
		this(person.getName(),
				person.getSurName(),
				person.getPhone(),
				person.getDepartment());
	}

	// Getters
	public String getName() {
		return name;
	}


	public String getSurName() {
		return surName;
	}

	public String getFullName() {
		return name + " " + surName;
	}

	public String getPhone() {
		return phone;
	}


	public Department getDepartment() {
		return department;
	}


	// Setters
	public void setName(String name) {
		verifyNames(name);
		this.name = name;
	}


	public void setSurName(String surName) {
		verifyNames(surName);
		this.surName = surName;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public void setDepartment(Department department) {
		this.department = department;
	}
	
	// Methods	
	private static void verifyNames(String... names) {
		for (String name : names) {
			if (name == null) {
				throw new NullPointerException("Names cannot be null.");
			}
			if (name.length() < 2) {
				throw new IllegalArgumentException("Names cannot be shorter than two characters.");
			}
		}
	}
	
	@Override
	public String toString() {
		return String.format("%1$s[name=%2$s, surName=%3$s, phone=%4$s, department=%5$s]",
				getClass().getSimpleName(),
				name,
				surName,
				phone,
				department.getName());
	}
}
