package hr;

import java.util.regex.*;
import administration.Course;
import administration.Department;

public class Student extends Person {
	// Fields
	private String studentID;
	private Course course;
	private static int IDIndex = 0;
	
	// Constructors
	public Student(String name, String surName, String phone, Department department, Course course) {
		super(name, surName, phone, department);
		this.studentID = generateStudentID();
		this.course = course;
	}
	
	public Student(String name, String surName, String phone, Department department) {
		this(name, surName, phone, department, null);
	}
	
	public Student(String name, String surName, String phone) {
		this(name, surName, phone, null);
	}
	
	public Student(String name, String surName) {
		this(name, surName, null);
	}
	
	public Student(Person person, Course course) {
		super(person);
		this.studentID = generateStudentID();
		this.course = course;
	}
	
	public Student(Person person) {
		this(person, null);
	}
	
	public Student(Student student) {
		this(student, student.getCourse());
	}

	// Getters
	public String getStudentID() {
		return studentID;
	}

	public Course getCourse() {
		return course;
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
	
	public void setCourse(Course course) {
		this.course = course;
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
				"%1$s[name=%2$s, surName=%3$s, phone=%4$s, department=%5$s, studentID=%6$s, course=%7$s]",
				getClass().getSimpleName(),
				getName(),
				getSurName(),
				getPhone(),
				getDepartment().getName(),
				studentID,
				course.getName());
	}
}
