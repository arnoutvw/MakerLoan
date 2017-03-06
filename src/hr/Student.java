package hr;

import java.util.regex.*;
import java.util.ArrayList;
import java.util.List;

import administration.Course;
import administration.Department;

public class Student extends Person {
	// Fields
	private String studentID;
	private List<Course> courseList;
	
	private static ArrayList<Student> studentList = new ArrayList<>();
	private static int IDIndex = 0;
	
	// Constructors
	public Student(String name, String surName, String phone, Department department, List<Course> courseList) {
		super(name, surName, phone, department);
		this.studentID = generateStudentID();
		this.courseList = new ArrayList<>(courseList);
		studentList.add(this);
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
	
	public Student(Person person, List<Course> courseList) {
		super(person);
		this.studentID = generateStudentID();
		this.courseList = new ArrayList<>(courseList);
		studentList.add(this);
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

	public List<Course> getCourseList() {
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
				"Student %5$s: %1$s %2$s  |  Phone: %3$s  -  Department: %4$s  -  Courses: %6$s",
				getName(),
				getSurName(),
				getPhone(),
				getDepartment() != null ? getDepartment().getName() : "",
				studentID,
				courseList);
	}
}
