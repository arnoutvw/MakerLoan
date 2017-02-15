package hr;

import java.util.regex.*;
import java.util.ArrayList;
import administration.Course;
import administration.Department;

public class Student extends Person {
	// Fields
	private String studentID;
	private ArrayList<Course> courseList;
	private static int IDIndex = 0;
	
	// Constructors
	public Student(String name, String surName, String phone, Department department, ArrayList<Course> courseList) {
		super(name, surName, phone, department);
		this.studentID = generateStudentID();
		this.courseList = courseList;
	}
	
	public Student(String name, String surName, String phone, Department department) {
		this(name, surName, phone, department, new ArrayList<>());
	}
	
	public Student(String name, String surName, String phone) {
		this(name, surName, phone, null);
	}
	
	public Student(String name, String surName) {
		this(name, surName, null);
	}
	
	public Student(Person person, ArrayList<Course> courseList) {
		super(person);
		this.studentID = generateStudentID();
		this.courseList = courseList;
	}
	
	public Student(Person person) {
		this(person, new ArrayList<>());
	}
	
	public Student(Student student) {
		this(student, student.getCourseList());
	}

	// Getters
	public String getStudentID() {
		return studentID;
	}

	public ArrayList<Course> getCourseList() {
		return courseList;
	}

	//Setters
	public void overrideStudentID(String studentID) {
		Pattern idPattern = Pattern.compile("^\\d{6}$");
		if (idPattern.matcher(studentID).matches()) {
			this.studentID = studentID;
		} else {
			throw new IllegalArgumentException("Incorrect studentID format.");
		}
	}
	
	// Methods
	private static String generateStudentID() {
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
		return String.format(
				"%1$s[name=%2$s, surName=%3$s, phone=%4$s, department=%5$s, studentID=%6$s, courses=%7$s]",
				getClass().getSimpleName(),
				getName(),
				getSurName(),
				getPhone(),
				getDepartment().getName(),
				studentID,
				courseList);
	}
}
