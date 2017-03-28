package no.hiof.itstud.krdehli.makerloan.administration;

public class UngradedCourse extends Course {
	
	private static final long serialVersionUID = -9222957858179106246L;

	//Constructors
	public UngradedCourse(String name, String courseID, Department department) {
		super(name, courseID, department, "Bestått / Ikke Bestått");
	}

	public UngradedCourse(Course course) {
		this(course.getName(), course.getCourseID(), course.getDepartment());
	}

}
