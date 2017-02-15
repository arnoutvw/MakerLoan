package administration;

public abstract class Course {
	// Fields
	private String name;
	private String courseID;
	private Department department;
	private final String evaluation;
	
	// Constructors
	protected Course(String name, String courseID, Department department, String evaluation) {
		this.name = name;
		this.courseID = courseID;
		this.department = department;
		this.evaluation = evaluation;
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
