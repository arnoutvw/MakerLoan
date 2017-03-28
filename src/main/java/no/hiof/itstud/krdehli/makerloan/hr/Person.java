package no.hiof.itstud.krdehli.makerloan.hr;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import no.hiof.itstud.krdehli.makerloan.administration.Department;


/**
 * A person with a name, surName and phone number that belongs to a department.
 * @author KIRODE
 *
 */
public abstract class Person implements Serializable {

	private static final long serialVersionUID = -1477534497071913735L;
	
	// Fields
	private String name;
	private String surName;
	private String phone;
	private Department department;
	
	private static List<Person> persons = new ArrayList<>();
	
	// Constructors
	/**
	 * Creates a new person with all required parameters.
	 * 
	 * @param name The given name of the person.
	 * @param surName The surname of the person.
	 * @param phone The persons phone number
	 * @param department The department that the person belongs to
	 */
	public Person(String name, String surName, String phone, Department department) {
		verifyNames(name, surName);
		this.name = name;
		this.surName = surName;
		this.phone = phone;
		this.department = department;
		persons.add(this);
	}
	
	/**
	 * Creates a new person without a department. Department is defaulted to null.
	 * 
	 * @param name The given name of the person.
	 * @param surName The surname of the person.
	 * @param phone The persons phone number
	 */
	public Person(String name, String surName, String phone) {
		this(name, surName, phone, null);
	}
	
	/**
	 * Creates a new person without a phone number or department. 
	 * Phone number and department is defaulted to null.
	 * 
	 * @param name The given name of the person.
	 * @param surName The surname of the person.
	 */
	public Person(String name, String surName) {
		this(name, surName, null);
	}
	
	/**
	 * A cloning constructor that creates a new person that is the exact copy of another person.
	 * 
	 * @param person The person that this person copies.
	 */
	public Person(Person person) {
		this(person.getName(),
				person.getSurName(),
				person.getPhone(),
				person.getDepartment());
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
	
	/**
	 * Returns a string representation of this person.
	 */
	@Override
	public String toString() {
		return String.format("%1$s[name=%2$s, surName=%3$s, phone=%4$s, department=%5$s]",
				getClass().getSimpleName(),
				name,
				surName,
				phone,
				department.getName());
	}

	// Getters
	/**
	 * @return The given name of this person.
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return The surname of this person.
	 */
	public String getSurName() {
		return surName;
	}

	/**
	 * @return The full name of this person.
	 */
	public String getFullName() {
		return name + " " + surName;
	}

	/**
	 * @return The phone number of this person.
	 */
	public String getPhone() {
		return phone;
	}


	/**
	 * @return the department this person belongs to.
	 */
	public Department getDepartment() {
		return department;
	}
	
	public static List<Person> getPersons() {
		return persons;
	}

	// Setters
	/**
	 * Sets this persons name to the argument name.
	 * @param name The new name of this person.
	 */
	public void setName(String name) {
		verifyNames(name);
		this.name = name;
	}


	/**
	 * Sets this persons surname to the argument surname.
	 * @param surName The new surname of this person.
	 */
	public void setSurName(String surName) {
		verifyNames(surName);
		this.surName = surName;
	}


	/**
	 * Sets this persons phone number to the argument phone. 
	 * @param phone The new phone number of this person.
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}


	/**
	 * Sets this persons department to the argument department.
	 * @param department The new deparment of this person. 
	 */
	public void setDepartment(Department department) {
		this.department = department;
	}
	
}
