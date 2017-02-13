package administration;

public class Course {
	// Fields
	private String name;
	private String courseID;
	private Department department;
	
	// Constructors
	public Course(String name, String courseID, Department department) {
		this.name = name;
		this.courseID = courseID;
		this.department = department;
	}
	
	public Course(Course course) {
		this(course.getName(), course.getCourseID(), course.getDepartment());
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
		return String.format("%1$s[name=%2$s, courseID=%3$s, department=%4$s]",
				getClass().getSimpleName(),
				name,
				courseID,
				department.getName());
	}
}
