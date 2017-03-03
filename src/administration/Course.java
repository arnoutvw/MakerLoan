package administration;

import java.util.ArrayList;
import java.util.List;

public abstract class Course {
	// Fields
	private String name;
	private String courseID;
	private Department department;
	private final String evaluation;
	private static List<Course> courses = new ArrayList<>();
	
	// Constructors
	protected Course(String name, String courseID, Department department, String evaluation) {
		this.name = name;
		this.courseID = courseID;
		this.department = department;
		this.evaluation = evaluation;
		courses.add(this);
	}

	// Getters
	public String getName() {
		return name;
	}

	public String getCourseID() {
		return courseID;
	}

	public Department getDepartment() {
		return department;
	}
	
	public String getEvaluation() {
		return evaluation;
	}
	
	public static List<Course> getCourses() {
		return courses;
	}

	// Setters
	public void setName(String name) {
		this.name = name;
	}

	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	// Methods
	@Override
	public String toString() {
		return String.format("%2$s: %1$s  -  Department: %3$s  -  Graded: %4$s",
				name,
				courseID,
				department.getName(),
				getEvaluation());
	}
}
