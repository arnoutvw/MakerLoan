package hr;

import java.util.regex.Pattern;

import administration.Department;

public class Employee extends Person {
	// Fields
	private String employeeID;
	private static int IDIndex = 0;
	
	// Constructors
	public Employee(String name, String surName, String phone, Department department) {
		super(name, surName, phone, department);
		this.employeeID = generateEmployeeID();
	}
	
	public Employee(String name, String surName, String phone) {
		this(name, surName, phone, null);
	}
	
	public Employee(String name, String surName) {
		this(name, surName, null);
	}
	
	public Employee(Person person) {
		super(person);
		this.employeeID = generateEmployeeID();
	}

	// Getters
	public String getEmployeeID() {
		return employeeID;
	}
	
	// Setters
	public void overrideEmployeeID(String employeeID) {
		Pattern idPattern = Pattern.compile("^\\d{6}$");
		if (idPattern.matcher(employeeID).matches()) {
			this.employeeID = employeeID;
		} else {
			throw new IllegalArgumentException("Incorrect employeeID format.");
		}
	}
	
	// Methods
	private static String generateEmployeeID()  {
		IDIndex++;
		String id = Integer.toString(IDIndex);
		String padding = "";
		for (int i = 0; i < (6 - id.length()); i++) {
			padding = padding + "0";
		}
		return padding + id;
	}
	
	@Override
	public String toString() {
		return String.format("%1$s[name=%2$s, surName=%3$s, phone=%4$s, department=%5$s, employeeID=%6$s]",
				getClass().getSimpleName(),
				getName(),
				getSurName(),
				getPhone(),
				getDepartment().getName(),
				employeeID);
	}
}
