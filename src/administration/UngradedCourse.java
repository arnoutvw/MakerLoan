package administration;

public class UngradedCourse extends Course {
	//Constructors
	public UngradedCourse(String name, String courseID, Department department) {
		super(name, courseID, department, "Best�tt / Ikke Best�tt");
	}

	public UngradedCourse(Course course) {
		this(course.getName(), course.getCourseID(), course.getDepartment());
	}

}
