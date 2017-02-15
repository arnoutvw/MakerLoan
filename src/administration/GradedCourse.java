package administration;

public class GradedCourse extends Course {
	//Constructors
	public GradedCourse(String name, String courseID, Department department) {
		super(name, courseID, department, "Karakter A-F");
	}

	public GradedCourse(Course course) {
		this(course.getName(), course.getCourseID(), course.getDepartment());
	}

}
